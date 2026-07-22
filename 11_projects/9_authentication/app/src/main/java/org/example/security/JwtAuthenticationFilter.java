package org.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.config.security.SecurityConfig;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        log.info("Authorization header: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = header.substring(7).trim();
        log.info("User Token: {}", token);
        try {
            // Prase JWT
            Jws<Claims> parse = jwtService.parse(token);
            Claims payload = parse.getPayload();


            if (!jwtService.isAccessToken(payload)) {
                filterChain.doFilter(request, response);
                return;
            }

            UUID userId = UUID.fromString(payload.getSubject());

            User user = userRepository.findById(userId).orElse(null);

            if (user == null || !user.isEnabled()) {
                filterChain.doFilter(request, response);
                return;
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = user.getRoles() == null ? List.of() :
                        user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, authorities);

                authenticationToken.setDetails(user);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (ExpiredJwtException ex) {
            request.setAttribute("error", "Token Expired");
        } catch (JwtException ex) {
            request.setAttribute("error", "Invalid Token");
        } catch (Exception ex) {
            request.setAttribute("error", "JWT authentication failed");
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Can be overridden in subclasses for custom filtering control,
     * returning {@code true} to avoid filtering of the given request.
     * <p>The default implementation always returns {@code false}.
     *
     * @param request current HTTP request
     * @return whether the given request should <i>not</i> be filtered
     * @throws ServletException in case of errors
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getRequestURI().startsWith("/api/v1/auth");
    }
}
