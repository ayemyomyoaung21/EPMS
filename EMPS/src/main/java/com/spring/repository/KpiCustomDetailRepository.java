package com.spring.repository;

import com.spring.model.KpiCustomDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiCustomDetailRepository extends JpaRepository<KpiCustomDetailEntity, Long> {
}