package com.spring.service;

import com.spring.model.OneOnOneMeetingEntity;
import com.spring.repository.OneOnOneMeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneOnOneMeetingService {
    
    @Autowired
    private OneOnOneMeetingRepository oneOnOneMeetingRepository;
}