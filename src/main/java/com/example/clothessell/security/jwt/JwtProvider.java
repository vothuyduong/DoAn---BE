package com.example.clothessell.security.jwt;

import com.example.clothessell.entity.Customer;
import com.example.clothessell.security.userprincipal.UserPrinciple;
import com.example.clothessell.service.impl.CustomerServiceImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "sora";
    private int jwtExpiration = 860000;

    @Autowired
    private CustomerServiceImpl customerService;

    public String createToken(Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired "+ e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Error signature");
        } catch(Exception e){
            System.out.println(" Some other exception in JWT parsing ");
        }
        return false;
    }

    public Customer getUsernameFromToken(String token) {
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        Customer customer = customerService.findByUsername(username);
        return customer;
    }
}
