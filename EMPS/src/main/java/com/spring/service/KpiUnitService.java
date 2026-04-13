package com.spring.service;

import com.spring.model.KpiUnitEntity;
import com.spring.repository.KpiUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiUnitService {
    
    @Autowired
    private KpiUnitRepository kpiUnitRepository;
}