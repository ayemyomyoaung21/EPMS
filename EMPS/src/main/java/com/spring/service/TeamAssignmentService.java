package com.spring.service;

import com.spring.model.TeamAssignmentEntity;
import com.spring.repository.TeamAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamAssignmentService {
    
    @Autowired
    private TeamAssignmentRepository teamAssignmentRepository;
}