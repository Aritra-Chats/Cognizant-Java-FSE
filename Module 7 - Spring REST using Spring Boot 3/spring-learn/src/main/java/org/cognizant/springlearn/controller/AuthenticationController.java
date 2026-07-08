package org.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Authorization START");
        Map<String, String> map = new HashMap<>();
        map.put("token", generateJWT(getUser(authHeader)));
        LOGGER.info("Authorization END");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.split(" ")[1];
        String loginDetails = new String(Base64.getDecoder().decode(encodedCredentials));
        LOGGER.info("loginDetails = {}", loginDetails);
        return loginDetails.split(":")[0];
    }

    private String generateJWT(String user) {
        SecretKey KEY = Keys.hmacShaKeyFor("my-super-secret-key-that-is-at-least-32-bytes-long"
                .getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder()
                .subject(user).issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + 1200000))
                .signWith(KEY).compact();
        LOGGER.info("token = {}", token);
        return token;
    }
}
