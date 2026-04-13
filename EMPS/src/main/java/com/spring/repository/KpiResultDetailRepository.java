package com.spring.repository;

import com.spring.model.KpiResultDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiResultDetailRepository extends JpaRepository<KpiResultDetailEntity, Long> {
}