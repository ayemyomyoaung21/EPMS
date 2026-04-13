package com.spring.service;

import com.spring.model.Feedback360FormEntity;
import com.spring.repository.Feedback360FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Feedback360FormService {
    
    @Autowired
    private Feedback360FormRepository feedback360FormRepository;
}