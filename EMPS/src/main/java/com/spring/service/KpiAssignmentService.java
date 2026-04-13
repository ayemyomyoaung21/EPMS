package com.spring.service;

import com.spring.model.KpiAssignmentEntity;
import com.spring.repository.KpiAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiAssignmentService {
    
    @Autowired
    private KpiAssignmentRepository kpiAssignmentRepository;
}