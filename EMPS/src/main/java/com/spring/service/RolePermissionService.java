package com.spring.service;

import com.spring.model.RolePermissionEntity;
import com.spring.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {
    
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
}