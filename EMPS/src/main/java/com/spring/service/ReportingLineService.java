package com.spring.service;

import com.spring.model.ReportingLineEntity;
import com.spring.repository.ReportingLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingLineService {
    
    @Autowired
    private ReportingLineRepository reportingLineRepository;
}