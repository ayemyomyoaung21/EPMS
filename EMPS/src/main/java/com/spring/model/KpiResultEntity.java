package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "kpi_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KpiResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private KpiAssignmentEntity assignment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private UserEntity employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appraisal_cycle_id")
    private AppraisalCycleEntity appraisalCycle;
    
    @Column(name = "template_version", nullable = false)
    private Integer templateVersion = 1;
    
    @Column(name = "total_score", precision = 6, scale = 2)
    private BigDecimal totalScore;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}