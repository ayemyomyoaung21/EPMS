package com.spring.service;

import com.spring.model.NotificationEntity;
import com.spring.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;
}