package com.spring.repository;

import com.spring.model.RatingScaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingScaleRepository extends JpaRepository<RatingScaleEntity, Long> {
}