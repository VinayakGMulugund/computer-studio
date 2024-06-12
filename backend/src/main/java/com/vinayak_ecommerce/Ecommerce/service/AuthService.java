package com.vinayak_ecommerce.Ecommerce.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class AuthService {

    public String generateToken(String email) {
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*10))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignatureKey() {
        byte[] keyInBytes = Decoders.BASE64.decode("thisisasecretkeybyvinayakandisafinalsecretkeey");
        return Keys.hmacShaKeyFor(keyInBytes);
    }

    public boolean validate(String token, UserDetails userDetails) {
        return (extractEmail(token).equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        Claims claims = extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build().parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
