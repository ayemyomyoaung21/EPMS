package com.spring.repository;

import com.spring.model.GeneratedReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedReportRepository extends JpaRepository<GeneratedReportEntity, Long> {
}