package com.spring.service;

import com.spring.model.PositionEntity;
import com.spring.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    
    @Autowired
    private PositionRepository positionRepository;
}