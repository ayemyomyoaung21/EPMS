package com.spring.repository;

import com.spring.model.AppraisalLockHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalLockHistoryRepository extends JpaRepository<AppraisalLockHistoryEntity, Long> {
}