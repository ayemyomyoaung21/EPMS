package com.spring.repository;

import com.spring.model.AppraisalTemplateDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalTemplateDetailRepository extends JpaRepository<AppraisalTemplateDetailEntity, Long> {
}