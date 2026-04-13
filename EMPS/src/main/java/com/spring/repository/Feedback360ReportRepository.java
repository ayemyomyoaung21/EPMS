package com.spring.repository;

import com.spring.model.Feedback360ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedback360ReportRepository extends JpaRepository<Feedback360ReportEntity, Long> {
}