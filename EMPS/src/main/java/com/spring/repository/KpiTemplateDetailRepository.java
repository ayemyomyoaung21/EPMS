package com.spring.repository;

import com.spring.model.KpiTemplateDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiTemplateDetailRepository extends JpaRepository<KpiTemplateDetailEntity, Long> {
}