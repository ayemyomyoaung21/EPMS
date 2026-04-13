package com.spring.repository;

import com.spring.model.SelfAssessmentResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfAssessmentResponseRepository extends JpaRepository<SelfAssessmentResponseEntity, Long> {
}