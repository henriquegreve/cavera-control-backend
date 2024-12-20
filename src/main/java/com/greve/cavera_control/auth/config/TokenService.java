package com.greve.cavera_control.auth.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.greve.cavera_control.auth.model.User;
import com.greve.cavera_control.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final UserRepository userRepository;

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create() //
                    .withIssuer("cavera-control-api") //
                    .withSubject(user.getUsername()) //
                    .withExpiresAt(genExpirationDate()) //
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm) //
                    .withIssuer("cavera-control-api") //
                    .build() //
                    .verify(token) //
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }

    public Long getUserFromToken(String token) {
        try {
            token = token.replace("Bearer ", "");

            String username = validateToken(token);

            return userRepository.findIdByEmailOrUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get user from token", e);
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00"));
    }
}