package com.spring.repository;

import com.spring.model.KpiUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiUnitRepository extends JpaRepository<KpiUnitEntity, Long> {
}