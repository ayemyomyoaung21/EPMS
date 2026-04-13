package com.spring.repository;

import com.spring.model.Feedback360FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedback360FormRepository extends JpaRepository<Feedback360FormEntity, Long> {
}