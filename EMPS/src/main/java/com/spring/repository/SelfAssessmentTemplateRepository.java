package com.spring.repository;

import com.spring.model.SelfAssessmentTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfAssessmentTemplateRepository extends JpaRepository<SelfAssessmentTemplateEntity, Long> {
}