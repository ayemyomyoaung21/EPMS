package com.spring.repository;

import com.spring.model.PipHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipHistoryRepository extends JpaRepository<PipHistoryEntity, Long> {
}