package com.spring.repository;

import com.spring.model.AppraisalResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalResponseRepository extends JpaRepository<AppraisalResponseEntity, Long> {
}