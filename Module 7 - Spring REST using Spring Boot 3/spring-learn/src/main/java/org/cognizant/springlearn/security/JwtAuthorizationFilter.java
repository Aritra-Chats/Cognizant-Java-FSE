package org.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter() { }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("JWT Authorization Filter Start");
        String header = req.getHeader("Authorization");
        LOGGER.debug("{}", header);
        if(header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        if(authentication != null)
            SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
        LOGGER.info("JWT Authorization Filter End");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        if(token != null) {
            SecretKey KEY = Keys.hmacShaKeyFor("my-super-secret-key-that-is-at-least-32-bytes-long"
                    .getBytes(StandardCharsets.UTF_8));
            Jws<Claims> jws;
            try {
                jws = Jwts.parser()
                        .verifyWith(KEY)
                        .build().parseSignedClaims(token.replace("Bearer ", ""));
                String user = jws.getPayload().getSubject();
                LOGGER.info("User: {}", user);
                if(user != null) {
                    List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
                    return new UsernamePasswordAuthenticationToken(user, null, authorities);
                }
            } catch (JwtException e) {
                return null;
            }
            return null;
        }
        return null;
    }
}
