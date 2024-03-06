package com.example.yttest.config;

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
//public class JWTService {
//
//
//    private  JwtEncoder jwtEncoder;
//
//    public JWTService(JwtEncoder jwtEncoder) {
//        this.jwtEncoder = jwtEncoder;
//    }
//
////    public String generateToken(Authentication authentication) {
////        Instant now = Instant.now();
////        JwtClaimsSet claims = JwtClaimsSet.builder()
////                .issuer("self")
////                .issuedAt(now)
////                .expiresAt(now.plus(1, ChronoUnit.DAYS))
////                .subject(authentication.getName())
////                .build();
////        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
////        return this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
////    }
//public String generateToken(UserDetails userDetails) {
//    Instant now = Instant.now();
//    JwtClaimsSet claims = JwtClaimsSet.builder()
//            .issuer("self")
//            .issuedAt(now)
//            .expiresAt(now.plus(1, ChronoUnit.DAYS))
//            .subject(userDetails.getUsername())
//            .claim("role", userDetails.getAuthorities())
//            .build();
//    JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
//    return this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
//}
//}

public class JWTService {


    public String SECRET="100aa60b3972fe7bc2aa2f7358d7b6d052e86e9bafa85c9fa335e203b7281846";

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractEmail(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String GenerateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails);
    }

    private String createToken(Map<String, Object> claims, UserDetails userDetails) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                //.claim("role", userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY * 1000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}