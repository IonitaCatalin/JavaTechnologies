package com.javatech.labs9.tokens;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenHandler {

    private static final String ISSUER = "Reviewer";
    private static final Long MILLIES = 0L;
    private static final String SECRET_KEY = "MTA1NDQ2NDYyMjkxODQ3NjI0NjM4NjUxNTYxZGZnMTU2MTQ4ZGY5NDE4MTk0OTg=";

    public static String issue (Long id) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        ObjectMapper oMapper = new ObjectMapper();
        Map<String,Object> accountData = new HashMap<>();
        accountData.put("id", id);

        Map<String, Object> claims = new HashMap<>(accountData);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setIssuer(ISSUER)
                .signWith(signatureAlgorithm, signingKey);

        if (MILLIES > 0) {
            long expMillis = nowMillis + MILLIES;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    public static Long validate(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody();

        return claims.get("id", Long.class);
    }
}
