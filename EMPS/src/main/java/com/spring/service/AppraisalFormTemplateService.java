package com.spring.service;

import com.spring.model.AppraisalFormTemplateEntity;
import com.spring.repository.AppraisalFormTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalFormTemplateService {
    
    @Autowired
    private AppraisalFormTemplateRepository appraisalFormTemplateRepository;
}