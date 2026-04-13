package com.spring.repository;

import com.spring.model.Feedback360CycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedback360CycleRepository extends JpaRepository<Feedback360CycleEntity, Long> {
}