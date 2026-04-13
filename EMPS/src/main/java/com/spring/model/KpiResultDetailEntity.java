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
@Table(name = "kpi_result_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KpiResultDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", nullable = false)
    private KpiResultEntity result;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_detail_id")
    private KpiTemplateDetailEntity templateDetail;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_detail_id")
    private KpiCustomDetailEntity customDetail;
    
    @Column(name = "actual_value", precision = 10, scale = 2)
    private BigDecimal actualValue;
    
    @Column(name = "score_percent", precision = 5, scale = 2)
    private BigDecimal scorePercent;
    
    @Column(name = "weighted_score", precision = 6, scale = 2)
    private BigDecimal weightedScore;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}