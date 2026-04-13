package com.spring.service;

import com.spring.model.CustomReportTemplateEntity;
import com.spring.repository.CustomReportTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomReportTemplateService {
    
    @Autowired
    private CustomReportTemplateRepository customReportTemplateRepository;
}