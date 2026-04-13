package com.spring.service;

import com.spring.model.PermissionEntity;
import com.spring.model.UserEntity;
import com.spring.model.UserPrincipal;
import com.spring.repository.PermissionRepository;
import com.spring.repository.RolePermissionRepository;
import com.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        
        // Get permissions based on user's position
        List<PermissionEntity> permissions = new ArrayList<>();
        
        if (userEntity.getPosition() != null) {
            // Fetch permissions assigned to this position
            permissions = permissionRepository.findPermissionsByPositionId(userEntity.getPosition().getId());
        }
        
        return new UserPrincipal(userEntity, permissions);
    }
}