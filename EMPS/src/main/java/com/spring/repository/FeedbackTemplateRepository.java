package com.spring.repository;

import com.spring.model.FeedbackTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackTemplateRepository extends JpaRepository<FeedbackTemplateEntity, Long> {
}