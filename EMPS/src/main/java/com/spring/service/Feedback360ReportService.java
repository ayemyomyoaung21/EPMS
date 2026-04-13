package com.spring.service;

import com.spring.model.Feedback360ReportEntity;
import com.spring.repository.Feedback360ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Feedback360ReportService {
    
    @Autowired
    private Feedback360ReportRepository feedback360ReportRepository;
}