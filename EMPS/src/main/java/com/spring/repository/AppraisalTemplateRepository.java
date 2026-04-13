package com.spring.repository;

import com.spring.model.AppraisalTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalTemplateRepository extends JpaRepository<AppraisalTemplateEntity, Long> {
}