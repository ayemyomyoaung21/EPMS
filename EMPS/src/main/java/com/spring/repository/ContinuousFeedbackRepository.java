package com.spring.repository;

import com.spring.model.ContinuousFeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinuousFeedbackRepository extends JpaRepository<ContinuousFeedbackEntity, Long> {
}