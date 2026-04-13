package com.spring.service;

import com.spring.model.UserEntity;
import com.spring.model.UserPrincipal;
import com.spring.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;
    
    private final UserRepository userRepository;

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails, long expirationMills) {
        return Jwts.builder()
                .claims()
                .add(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationMills))
                .and()
                .signWith(getSignKey())
                .compact();
    }

    public String generateAccessToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        
        // Add roles to token
        claims.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));
        
        // Get UserEntity to fetch permissions
        UserEntity user = userRepository.findByEmail(userDetails.getUsername()).orElse(null);
        
        if (user != null) {
            // Add user basic info
            claims.put("userId", user.getId());
            claims.put("staffNo", user.getStaffNo());
            claims.put("staffName", user.getStaffName());
            claims.put("role", user.getRole() != null ? user.getRole().getName() : "USER");
            claims.put("positionId", user.getPosition() != null ? user.getPosition().getId() : null);
            claims.put("positionName", user.getPosition() != null ? user.getPosition().getName() : null);
            claims.put("departmentId", user.getDepartment() != null ? user.getDepartment().getId() : null);
            claims.put("departmentName", user.getDepartment() != null ? user.getDepartment().getName() : null);
            
            // Add permissions from UserPrincipal
            if (userDetails instanceof UserPrincipal) {
                UserPrincipal userPrincipal = (UserPrincipal) userDetails;
                claims.put("permissions", userPrincipal.getPermissions());
                claims.put("dataScope", userPrincipal.getDataScopes());
            }
        }
        
        claims.put("email", userDetails.getUsername());
        
        return generateToken(claims, userDetails, 1000 * 60 * 60); // 1 hour
    }

    public String generateRefreshToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", userDetails.getUsername());
        return generateToken(claims, userDetails, 1000 * 60 * 60 * 24 * 7); // 7 days
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    
    // Extract permissions from token
    public List<String> extractPermissions(String token) {
        Claims claims = extractAllClaims(token);
        return (List<String>) claims.get("permissions");
    }
    
    // Extract data scope from token
    public Map<String, String> extractDataScopes(String token) {
        Claims claims = extractAllClaims(token);
        return (Map<String, String>) claims.get("dataScope");
    }
    
    // Extract user role from token
    public String extractUserRole(String token) {
        Claims claims = extractAllClaims(token);
        return (String) claims.get("role");
    }
}