package com.spring.service;

import com.spring.model.RatingScaleEntity;
import com.spring.repository.RatingScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingScaleService {
    
    @Autowired
    private RatingScaleRepository ratingScaleRepository;
}