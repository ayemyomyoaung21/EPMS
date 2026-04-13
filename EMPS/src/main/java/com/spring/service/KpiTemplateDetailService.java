package com.spring.service;

import com.spring.model.KpiTemplateDetailEntity;
import com.spring.repository.KpiTemplateDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiTemplateDetailService {
    
    @Autowired
    private KpiTemplateDetailRepository kpiTemplateDetailRepository;
}