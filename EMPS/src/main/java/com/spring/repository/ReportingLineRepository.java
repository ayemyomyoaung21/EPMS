package com.spring.repository;

import com.spring.model.ReportingLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingLineRepository extends JpaRepository<ReportingLineEntity, Long> {
}