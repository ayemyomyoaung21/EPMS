package com.spring.service;

import com.spring.model.AppraisalCycleEntity;
import com.spring.repository.AppraisalCycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalCycleService {
    
    @Autowired
    private AppraisalCycleRepository appraisalCycleRepository;
}