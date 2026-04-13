package com.spring.repository;

import com.spring.model.TeamAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamAssignmentRepository extends JpaRepository<TeamAssignmentEntity, Long> {
}