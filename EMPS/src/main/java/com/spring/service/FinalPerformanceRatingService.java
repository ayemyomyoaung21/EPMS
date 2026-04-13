package com.spring.service;

import com.spring.model.FinalPerformanceRatingEntity;
import com.spring.repository.FinalPerformanceRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalPerformanceRatingService {
    
    @Autowired
    private FinalPerformanceRatingRepository finalPerformanceRatingRepository;
}