package com.spring.repository;

import com.spring.model.CustomReportTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomReportTemplateRepository extends JpaRepository<CustomReportTemplateEntity, Long> {
}