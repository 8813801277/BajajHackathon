package com.mukul.Bajaj.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {

    private static final String SECRET_KEY_STRING = "QUtFWVRIQVRJU0xPTkdFTk9VR0hUT0JFVVNFREZPUkhTMjU2QUxHT1JJVE5NQU5ETVVTVEJFQVRMRUFTVDMyQllURVM=";

    private final SecretKey key;
    private static final long EXPIRATION_TIME = 3600000; // 1 hour

    public JWTUtil() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        try {
            Claims claims = extractAllClaims(token);
            String extractedUsername = claims.getSubject();
            Date expirationDate = claims.getExpiration();

            return (username.equals(extractedUsername) && !expirationDate.before(new Date()));
        } catch (Exception e) {
            System.err.println("Token validation error: " + e.getMessage());
            return false;
        }
    }

    public String extractUsername(String token) {
        try {
            return extractAllClaims(token).getSubject();
        } catch (Exception e) {
            System.err.println("Error extracting username: " + e.getMessage());
            return null;
        }
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
