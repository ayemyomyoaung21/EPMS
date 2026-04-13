package com.spring.service;

import com.spring.model.SelfAssessmentTemplateEntity;
import com.spring.repository.SelfAssessmentTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfAssessmentTemplateService {
    
    @Autowired
    private SelfAssessmentTemplateRepository selfAssessmentTemplateRepository;
}