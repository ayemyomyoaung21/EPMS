package com.spring.service;

import com.spring.model.PipMeetingEntity;
import com.spring.repository.PipMeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipMeetingService {
    
    @Autowired
    private PipMeetingRepository pipMeetingRepository;
}