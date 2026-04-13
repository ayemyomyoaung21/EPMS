package com.spring.repository;

import com.spring.model.AppraisalAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalAssignmentRepository extends JpaRepository<AppraisalAssignmentEntity, Long> {
}