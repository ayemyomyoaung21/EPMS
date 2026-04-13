package com.spring.service;

import com.spring.model.AppraisalLockHistoryEntity;
import com.spring.repository.AppraisalLockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppraisalLockHistoryService {
    
    @Autowired
    private AppraisalLockHistoryRepository appraisalLockHistoryRepository;
}