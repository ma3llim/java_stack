package com.sameer.spring_security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JwtService {
    private String secretKey;

    public JwtService(){
        secretKey = generateSeckey();
    }

     public String generateSeckey(){
         try {
             KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
             SecretKey secretKey = keyGen.generateKey();
             return Base64.getEncoder().encodeToString(secretKey.getEncoded());
         } catch (NoSuchAlgorithmException e) {
             throw new RuntimeException(e);
         }
     }



    public String generateToken(String username) {
        Map<String, Objects> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*3))
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
