package com.spring.service;

import com.spring.model.AppraisalResponseEntity;
import com.spring.repository.AppraisalResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalResponseService {
    
    @Autowired
    private AppraisalResponseRepository appraisalResponseRepository;
}