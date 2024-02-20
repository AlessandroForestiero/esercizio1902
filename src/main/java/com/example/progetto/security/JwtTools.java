package com.example.progetto.security;

import com.example.progetto.entities.Utente;
import com.example.progetto.exceptions.UnauthorizedException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("application.properties")
public class JwtTools {

    @Value("${spring.jwt.secret}")
    private String secret;

    @Value("${spring.jwt.expirationMs}")
    private String expiration;

    public String createToken(Utente utente){
        return Jwts.builder().subject(utente.getUsername()).issuedAt(new Date(System.currentTimeMillis())).
                expiration(new Date(System.currentTimeMillis() + Long.parseLong(expiration))).
                signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
    }

    public void validateToken(String token){
        try {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
        }
        catch(Exception e){
            throw new UnauthorizedException(e.getMessage());
        }
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parseSignedClaims(token).
                getPayload().getSubject();
    }
}
