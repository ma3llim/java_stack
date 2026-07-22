package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dtos.ErrorResponseDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ErrorResponseWriter {
    private final ObjectMapper objectMapper;

    public void writeErrorResponse(HttpServletRequest request, HttpServletResponse response,
                                   int status, String message) throws IOException {

        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error(HttpServletResponse.SC_UNAUTHORIZED == status ? "Unauthorized" : "Error")
                .message(message)
                .path(request.getRequestURI())
                .build();

        response.setStatus(status);
        response.setContentType("application/json");

        response.getWriter()
                .write(objectMapper.writeValueAsString(errorResponse));
    }
}
