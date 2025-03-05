/*package com.leovegas.game.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import java.util.Date;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()  // Permite todas as requisições
                .and()
                .csrf().disable(); // Desativa o CSRF (pode ser necessário em algumas situações de API)

        return http.build();
    }
}*/
/*

@Service
public class JwtService{
    private final String SECRET_KEY = "d41d8cd98f00b204e9800998ecf8427e";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Boolean validateToken(String token) {
        /*return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        try {
            // Usando parserBuilder para validar o token e obter os claims
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)  // Define a chave secreta para validação da assinatura
                    .build()
                    .parseClaimsJws(token);  // Faz o parse do token e valida a assinatura

            // Se não lançar exceção, o token é válido
            return true;

        } catch (SignatureException e) {
            // Se o token não for válido (assinatura incorreta)
            return false;
        } catch (Exception e) {
            // Outras exceções (ex: token expirado, mal formado, etc.)
            return false;
        }
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /*public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}*/