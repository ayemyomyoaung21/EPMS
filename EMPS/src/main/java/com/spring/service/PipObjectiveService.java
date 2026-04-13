package com.spring.service;

import com.spring.model.PipObjectiveEntity;
import com.spring.repository.PipObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipObjectiveService {
    
    @Autowired
    private PipObjectiveRepository pipObjectiveRepository;
}