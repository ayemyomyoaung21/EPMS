package com.spring.repository;

import com.spring.model.PerformanceImprovementPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceImprovementPlanRepository extends JpaRepository<PerformanceImprovementPlanEntity, Long> {
}