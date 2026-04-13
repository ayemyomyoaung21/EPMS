package com.spring.service;

import com.spring.model.KpiCategoryEntity;
import com.spring.repository.KpiCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiCategoryService {
    
    @Autowired
    private KpiCategoryRepository kpiCategoryRepository;
}