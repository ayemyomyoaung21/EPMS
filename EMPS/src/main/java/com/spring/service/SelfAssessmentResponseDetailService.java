package com.spring.service;

import com.spring.model.SelfAssessmentResponseDetailEntity;
import com.spring.repository.SelfAssessmentResponseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfAssessmentResponseDetailService {
    
    @Autowired
    private SelfAssessmentResponseDetailRepository selfAssessmentResponseDetailRepository;
}