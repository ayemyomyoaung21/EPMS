package com.spring.repository;

import com.spring.model.KpiAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiAssignmentRepository extends JpaRepository<KpiAssignmentEntity, Long> {
}