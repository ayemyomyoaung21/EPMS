package com.spring.repository;

import com.spring.model.AppraisalCycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalCycleRepository extends JpaRepository<AppraisalCycleEntity, Long> {
}