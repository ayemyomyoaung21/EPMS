package com.spring.service;

import com.spring.model.KpiTemplateEntity;
import com.spring.repository.KpiTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiTemplateService {
    
    @Autowired
    private KpiTemplateRepository kpiTemplateRepository;
}