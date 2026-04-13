package com.spring.repository;

import com.spring.model.AppraisalFormTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalFormTemplateRepository extends JpaRepository<AppraisalFormTemplateEntity, Long> {
}