package com.thutasann.project_management_backend.utilities;

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
    static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    /**
     * Generate Token
     * 
     * @apiNote - expired after `24` hours
     * @param auth - authentication
     * @return jwt string
     */
    public static String generateToken(Authentication auth) {
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .claim("email", auth.getName())
                .signWith(key)
                .compact();

        return jwt;
    }

    /**
     * Get Email from Token
     * 
     * @param jwt - jwt token
     * @return - email from token
     */
    public static String getEmailFromToken(String jwt) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

        String email = String.valueOf(claims.get("email"));

        return email;
    }
}
