package com.spring.repository;

import com.spring.model.AppraisalResponseDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalResponseDetailRepository extends JpaRepository<AppraisalResponseDetailEntity, Long> {
}