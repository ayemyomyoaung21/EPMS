package com.spring.repository;

import com.spring.model.KpiResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiResultRepository extends JpaRepository<KpiResultEntity, Long> {
}