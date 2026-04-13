package com.spring.service;

import com.spring.model.SelfAssessmentResponseEntity;
import com.spring.repository.SelfAssessmentResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfAssessmentResponseService {
    
    @Autowired
    private SelfAssessmentResponseRepository selfAssessmentResponseRepository;
}