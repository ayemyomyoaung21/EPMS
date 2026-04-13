package com.spring.repository;

import com.spring.model.Feedback360ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedback360ResponseRepository extends JpaRepository<Feedback360ResponseEntity, Long> {
}