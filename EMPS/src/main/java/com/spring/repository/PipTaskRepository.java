package com.spring.repository;

import com.spring.model.PipTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipTaskRepository extends JpaRepository<PipTaskEntity, Long> {
}