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
@Table(name = "final_performance_ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalPerformanceRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private UserEntity employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appraisal_cycle_id", nullable = false)
    private AppraisalCycleEntity appraisalCycle;
    
    @Column(name = "kpi_score", precision = 5, scale = 2)
    private BigDecimal kpiScore;
    
    @Column(name = "appraisal_score", precision = 5, scale = 2)
    private BigDecimal appraisalScore;
    
    @Column(name = "final_score", precision = 5, scale = 2)
    private BigDecimal finalScore;
    
    @Column(name = "rating_value")
    private Integer ratingValue;
    
    @Column(name = "performance_level", length = 50)
    private String performanceLevel;
    
    @Column(name = "promotion_recommendation", length = 50)
    private String promotionRecommendation;
    
    @CreationTimestamp
    @Column(name = "calculated_at", updatable = false)
    private LocalDateTime calculatedAt;
}