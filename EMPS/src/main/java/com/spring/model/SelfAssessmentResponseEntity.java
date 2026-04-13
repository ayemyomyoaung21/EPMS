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
@Table(name = "self_assessment_responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelfAssessmentResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private UserEntity employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private SelfAssessmentTemplateEntity template;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appraisal_cycle_id", nullable = false)
    private AppraisalCycleEntity appraisalCycle;
    
    @Column(name = "total_points", precision = 8, scale = 2)
    private BigDecimal totalPoints;
    
    @Column(name = "score_percentage", precision = 5, scale = 2)
    private BigDecimal scorePercentage;
    
    @Column(length = 20)
    private String status = "DRAFT";
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;
    
    @Column(name = "manager_comments", columnDefinition = "TEXT")
    private String managerComments;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}