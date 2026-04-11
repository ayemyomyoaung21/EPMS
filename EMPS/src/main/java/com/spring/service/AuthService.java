package com.spring.service;

import com.spring.dto.RegisterDto;
import com.spring.model.*;

public interface AuthService {
    User register(RegisterDto registerDto);
    AuthResponse login(AuthRequest request);
    AuthResponse refreshToken(RefreshTokenRequest refreshRequest);
    User getCurrentUser();
}
