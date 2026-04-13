package com.spring.service;

import com.spring.model.Feedback360CycleEntity;
import com.spring.repository.Feedback360CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Feedback360CycleService {
    
    @Autowired
    private Feedback360CycleRepository feedback360CycleRepository;
}