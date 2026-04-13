package com.spring.service;

import com.spring.model.KpiCustomDetailEntity;
import com.spring.repository.KpiCustomDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiCustomDetailService {
    
    @Autowired
    private KpiCustomDetailRepository kpiCustomDetailRepository;
}