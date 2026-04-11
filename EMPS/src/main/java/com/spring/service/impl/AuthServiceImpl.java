package com.spring.service.impl;

import com.spring.security.model.*;
import com.spring.security.repository.RoleRepository;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.AuthService;
import com.spring.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final RoleRepository roleRepository;
    @Override
    public User register(RegisterDto registerDto) {
        User user = new User();

        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setProvider(AuthProvider.LOCAL); // local registration
        user.setProviderId(null);
        Role role;
        if(registerDto.getRoleId() != null){
            role = roleRepository.findById(registerDto.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
        }else{
            role = roleRepository.findByRole(RoleType.USER)
                    .orElseThrow(() -> new RuntimeException("Default role not found"));
        }
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("user not found"));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getEmail());

        // generate tokens
        String accessToken = jwtService.generateAccessToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(userDetails);

        return new AuthResponse(accessToken, refreshToken, "Login success");
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshRequest) {
        String refreshToken = refreshRequest.getRefreshToken();

        //extract username first to load user details
        String username = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        //Now validate the refresh token with the user details
        if(!jwtService.isTokenValid(refreshToken,userDetails)){
            throw new RuntimeException("Invalid Refresh Token");
        }
        String newAccessToken = jwtService.generateAccessToken(userDetails);
        return new AuthResponse(newAccessToken, refreshToken, "new token success");
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
