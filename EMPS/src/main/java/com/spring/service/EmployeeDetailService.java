package com.spring.service;

import com.spring.model.EmployeeDetailEntity;
import com.spring.repository.EmployeeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailService {
    
    @Autowired
    private EmployeeDetailRepository employeeDetailRepository;
}