package com.spring.service;

import com.spring.model.DepartmentEntity;
import com.spring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;
}