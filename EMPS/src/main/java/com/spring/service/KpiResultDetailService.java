package com.spring.service;

import com.spring.model.KpiResultDetailEntity;
import com.spring.repository.KpiResultDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiResultDetailService {
    
    @Autowired
    private KpiResultDetailRepository kpiResultDetailRepository;
}