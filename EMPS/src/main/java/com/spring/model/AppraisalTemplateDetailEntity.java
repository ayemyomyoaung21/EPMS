package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "appraisal_template_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppraisalTemplateDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private AppraisalTemplateEntity template;
    
    @Column(name = "section_name", nullable = false, length = 200)
    private String sectionName;
    
    @Column(name = "criteria_name", nullable = false, length = 500)
    private String criteriaName;
    
    @Column(name = "sort_order")
    private Integer sortOrder = 0;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}