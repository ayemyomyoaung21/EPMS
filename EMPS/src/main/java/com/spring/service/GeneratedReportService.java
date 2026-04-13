package com.spring.service;

import com.spring.model.GeneratedReportEntity;
import com.spring.repository.GeneratedReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratedReportService {
    
    @Autowired
    private GeneratedReportRepository generatedReportRepository;
}