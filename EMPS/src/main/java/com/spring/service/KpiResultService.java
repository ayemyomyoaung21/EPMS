package com.spring.service;

import com.spring.model.KpiResultEntity;
import com.spring.repository.KpiResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiResultService {
    
    @Autowired
    private KpiResultRepository kpiResultRepository;
}