package com.spring.repository;

import com.spring.model.KpiTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiTemplateRepository extends JpaRepository<KpiTemplateEntity, Long> {
}