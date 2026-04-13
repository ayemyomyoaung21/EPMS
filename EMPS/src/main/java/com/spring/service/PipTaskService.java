package com.spring.service;

import com.spring.model.PipTaskEntity;
import com.spring.repository.PipTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipTaskService {
    
    @Autowired
    private PipTaskRepository pipTaskRepository;
}