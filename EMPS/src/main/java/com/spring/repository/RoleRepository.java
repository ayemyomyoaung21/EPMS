package com.spring.repository;

import com.spring.security.model.Role;
import com.spring.security.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRole(RoleType roleType);
}
