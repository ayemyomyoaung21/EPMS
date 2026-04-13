package com.spring.service;

import com.spring.model.PerformanceImprovementPlanEntity;
import com.spring.repository.PerformanceImprovementPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceImprovementPlanService {
    
    @Autowired
    private PerformanceImprovementPlanRepository performanceImprovementPlanRepository;
}