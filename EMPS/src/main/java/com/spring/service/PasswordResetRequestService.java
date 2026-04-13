package com.spring.service;

import com.spring.model.PasswordResetRequestEntity;
import com.spring.repository.PasswordResetRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetRequestService {
    
    @Autowired
    private PasswordResetRequestRepository passwordResetRequestRepository;
}