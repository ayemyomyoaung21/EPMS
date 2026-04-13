package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pip_objectives")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PipObjectiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pip_id", nullable = false)
    private PerformanceImprovementPlanEntity pip;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "target_completion_date", nullable = false)
    private LocalDate targetCompletionDate;
    
    @Column(length = 20)
    private String status = "NOT_STARTED";
    
    @Column(name = "progress_percentage", precision = 5, scale = 2)
    private BigDecimal progressPercentage = BigDecimal.ZERO;
    
    @Column(name = "order_index")
    private Integer orderIndex = 0;
}