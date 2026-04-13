package com.spring.service;

import com.spring.model.PermissionEntity;
import com.spring.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    
    @Autowired
    private PermissionRepository permissionRepository;
}