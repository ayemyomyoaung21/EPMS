package com.spring.model;

import com.spring.repository.RolePermissionRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private UserEntity userEntity;
    private List<String> permissions;
    private Map<String, String> dataScopes;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(UserEntity userEntity, List<PermissionEntity> permissionEntities) {
        this.userEntity = userEntity;
        
        // Build permissions list
        this.permissions = permissionEntities.stream()
                .map(p -> p.getModule() + ":" + p.getAction())
                .collect(Collectors.toList());
        
        // Build data scopes per module
        this.dataScopes = new HashMap<>();
        for (PermissionEntity p : permissionEntities) {
            dataScopes.put(p.getModule(), p.getDataScope());
        }
        
        // Build authorities (roles + permissions)
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().getName()));
        for (String permission : permissions) {
            authList.add(new SimpleGrantedAuthority(permission));
        }
        this.authorities = authList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.getLockedUntil() == null || 
               userEntity.getLockedUntil().isBefore(java.time.LocalDateTime.now());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.getIsActive();
    }
    
    public Long getId() {
        return userEntity.getId();
    }
    
    public String getStaffNo() {
        return userEntity.getStaffNo();
    }
    
    public String getStaffName() {
        return userEntity.getStaffName();
    }
    
    public List<String> getPermissions() {
        return permissions;
    }
    
    public Map<String, String> getDataScopes() {
        return dataScopes;
    }
    
    public boolean hasPermission(String module, String action) {
        String permission = module + ":" + action;
        return permissions.contains(permission);
    }
    
    public String getDataScopeForModule(String module) {
        return dataScopes.getOrDefault(module, "NO_ACCESS");
    }
}