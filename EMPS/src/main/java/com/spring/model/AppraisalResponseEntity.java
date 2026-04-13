package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "appraisal_response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private AppraisalAssignmentEntity assignment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private UserEntity employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private UserEntity manager;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appraisal_cycle_id", nullable = false)
    private AppraisalCycleEntity appraisalCycle;
    
    @Column(name = "template_version", nullable = false)
    private Integer templateVersion;
    
    @Column(name = "total_points", precision = 8, scale = 2)
    private BigDecimal totalPoints;
    
    @Column(name = "max_points", precision = 8, scale = 2)
    private BigDecimal maxPoints;
    
    @Column(name = "score_percentage", precision = 5, scale = 2)
    private BigDecimal scorePercentage;
    
    @Column(columnDefinition = "TEXT")
    private String comments;
    
    @Column(length = 20)
    private String status = "DRAFT";
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;
    
    @Column(name = "locked_at")
    private LocalDateTime lockedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locked_by_id")
    private UserEntity lockedBy;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}