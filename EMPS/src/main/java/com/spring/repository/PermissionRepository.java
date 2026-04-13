package com.spring.repository;

import com.spring.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    
    @Query("SELECT p FROM PermissionEntity p " +
           "JOIN RolePermissionEntity rp ON rp.permission.id = p.id " +
           "WHERE rp.position.id = :positionId AND rp.isGranted = true")
    List<PermissionEntity> findPermissionsByPositionId(@Param("positionId") Long positionId);
}