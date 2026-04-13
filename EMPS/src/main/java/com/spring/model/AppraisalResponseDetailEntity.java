package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "appraisal_response_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalResponseDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id", nullable = false)
    private AppraisalResponseEntity response;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_detail_id", nullable = false)
    private AppraisalTemplateDetailEntity templateDetail;
    
    @Column(name = "rating_value", nullable = false)
    private Integer ratingValue;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}