package com.spring.repository;

import com.spring.model.KpiCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiCategoryRepository extends JpaRepository<KpiCategoryEntity, Long> {
}