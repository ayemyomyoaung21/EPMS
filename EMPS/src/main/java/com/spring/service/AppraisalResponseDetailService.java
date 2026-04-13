package com.spring.service;

import com.spring.model.AppraisalResponseDetailEntity;
import com.spring.repository.AppraisalResponseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalResponseDetailService {
    
    @Autowired
    private AppraisalResponseDetailRepository appraisalResponseDetailRepository;
}