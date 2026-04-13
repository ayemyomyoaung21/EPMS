package com.spring.repository;

import com.spring.model.Feedback360ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedback360ProviderRepository extends JpaRepository<Feedback360ProviderEntity, Long> {
}