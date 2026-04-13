package com.spring.service;

import com.spring.model.FeedbackReplyEntity;
import com.spring.repository.FeedbackReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackReplyService {
    
    @Autowired
    private FeedbackReplyRepository feedbackReplyRepository;
}