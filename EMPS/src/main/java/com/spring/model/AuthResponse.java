package com.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String access_token;
    private String refresh_token;
    private String message;
    private UserInfo userInfo;
    
    // Constructor for basic response
    public AuthResponse(String access_token, String refresh_token, String message) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.message = message;
    }
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        private Long id;
        private String staffNo;
        private String staffName;
        private String email;
        private String role;
        private String positionName;
        private String departmentName;
        private List<String> permissions;
        private Map<String, String> dataScopes;
    }
}