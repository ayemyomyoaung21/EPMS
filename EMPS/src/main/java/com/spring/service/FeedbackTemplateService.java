package com.spring.service;

import com.spring.model.FeedbackTemplateEntity;
import com.spring.repository.FeedbackTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackTemplateService {
    
    @Autowired
    private FeedbackTemplateRepository feedbackTemplateRepository;
}