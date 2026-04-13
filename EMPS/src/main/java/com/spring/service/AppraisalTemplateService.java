package com.spring.service;

import com.spring.model.AppraisalTemplateEntity;
import com.spring.repository.AppraisalTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalTemplateService {
    
    @Autowired
    private AppraisalTemplateRepository appraisalTemplateRepository;
}