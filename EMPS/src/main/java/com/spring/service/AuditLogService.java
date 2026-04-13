package com.spring.service;

import com.spring.model.AuditLogEntity;
import com.spring.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {
    
    @Autowired
    private AuditLogRepository auditLogRepository;
}