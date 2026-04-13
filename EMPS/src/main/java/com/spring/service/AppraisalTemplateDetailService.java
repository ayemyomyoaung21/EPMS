package com.spring.service;

import com.spring.model.AppraisalTemplateDetailEntity;
import com.spring.repository.AppraisalTemplateDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalTemplateDetailService {
    
    @Autowired
    private AppraisalTemplateDetailRepository appraisalTemplateDetailRepository;
}