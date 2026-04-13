package com.spring.service;

import com.spring.model.PipHistoryEntity;
import com.spring.repository.PipHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipHistoryService {
    
    @Autowired
    private PipHistoryRepository pipHistoryRepository;
}