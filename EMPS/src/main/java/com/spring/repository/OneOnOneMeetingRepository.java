package com.spring.repository;

import com.spring.model.OneOnOneMeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneOnOneMeetingRepository extends JpaRepository<OneOnOneMeetingEntity, Long> {
}