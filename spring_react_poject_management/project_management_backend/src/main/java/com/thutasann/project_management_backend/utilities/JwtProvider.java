package com.thutasann.project_management_backend.utilities;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import com.thutasann.project_management_backend.config.JwtConstant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * JWT Provider
 */
public class JwtProvider {
    static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    private static final long EXPIRATION_TIME_MS = 24 * 60 * 60 * 1000; // 24 hours

    /**
     * Generate Token
     * 
     * @apiNote - expired after `24` hours
     * @param auth - authentication
     * @return jwt string
     */
    public static String generateToken(Authentication auth) {
        if (auth == null || auth.getName() == null) {
            throw new IllegalArgumentException("Authentication object is null or invalid");
        }

        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))
                .claim("email", auth.getName())
                .signWith(key) // Uses a secure HMAC SHA-256 algorithm
                .compact();
    }

    /**
     * Get Email from Token
     * 
     * @param jwt - jwt token
     * @return - email from token
     */
    public static String getEmailFromToken(String jwt) {
        jwt = jwt.substring(7).trim();
        System.out.println("getEmailFromToken jwt -> " + jwt);
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

        String email = String.valueOf(claims.get("email"));

        return email;
    }
}
