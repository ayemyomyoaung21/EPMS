package com.spring.service;

import com.spring.model.*;
import com.spring.repository.RoleRepository;
import com.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final RoleRepository roleRepository;

    // LOGIN METHOD - YOUR RESPONSIBILITY
    public AuthResponse login(AuthRequest request) {
        UserEntity userEntity = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (userEntity.getLockedUntil() != null && 
            userEntity.getLockedUntil().isAfter(java.time.LocalDateTime.now())) {
            throw new RuntimeException("Account is locked. Please try again later.");
        }
        
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        
        userEntity.setFailedLoginAttempts(0);
        userEntity.setLockedUntil(null);
        userEntity.setLastLogin(java.time.LocalDateTime.now());
        userRepository.save(userEntity);
        
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());

        String accessToken = jwtService.generateAccessToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);
        
        // Build user info for response
        AuthResponse.UserInfo userInfo = new AuthResponse.UserInfo();
        userInfo.setId(userEntity.getId());
        userInfo.setStaffNo(userEntity.getStaffNo());
        userInfo.setStaffName(userEntity.getStaffName());
        userInfo.setEmail(userEntity.getEmail());
        userInfo.setRole(userEntity.getRole() != null ? userEntity.getRole().getName() : "USER");
        userInfo.setPositionName(userEntity.getPosition() != null ? userEntity.getPosition().getName() : null);
        userInfo.setDepartmentName(userEntity.getDepartment() != null ? userEntity.getDepartment().getName() : null);
        
        // Get permissions from UserPrincipal
        if (userDetails instanceof UserPrincipal) {
            UserPrincipal userPrincipal = (UserPrincipal) userDetails;
            userInfo.setPermissions(userPrincipal.getPermissions());
            userInfo.setDataScopes(userPrincipal.getDataScopes());
        }

        return new AuthResponse(accessToken, refreshToken, "Login success", userInfo);
    }

    // REFRESH TOKEN METHOD - YOUR RESPONSIBILITY
    public AuthResponse refreshToken(RefreshTokenRequest refreshRequest) {
        String refreshToken = refreshRequest.getRefreshToken();

        String username = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        if (!jwtService.isTokenValid(refreshToken, userDetails)) {
            throw new RuntimeException("Invalid Refresh Token");
        }
        String newAccessToken = jwtService.generateAccessToken(userDetails);
        return new AuthResponse(newAccessToken, refreshToken, "Token refreshed successfully");
    }

    // GET CURRENT USER - YOUR RESPONSIBILITY
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}