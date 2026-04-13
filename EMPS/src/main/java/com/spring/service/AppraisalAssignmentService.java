package com.spring.service;

import com.spring.model.AppraisalAssignmentEntity;
import com.spring.repository.AppraisalAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalAssignmentService {
    
    @Autowired
    private AppraisalAssignmentRepository appraisalAssignmentRepository;
}