package com.spring.service;

import com.spring.model.ContinuousFeedbackEntity;
import com.spring.repository.ContinuousFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinuousFeedbackService {
    
    @Autowired
    private ContinuousFeedbackRepository continuousFeedbackRepository;
}