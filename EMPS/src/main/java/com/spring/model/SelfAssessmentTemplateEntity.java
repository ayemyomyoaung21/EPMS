package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "self_assessment_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelfAssessmentTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private Integer version = 1;
    
    @Column(nullable = false, columnDefinition = "json")
    private String questions;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_scale_id")
    private RatingScaleEntity ratingScale;
    
    @Column(columnDefinition = "TEXT")
    private String instructions;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_admin_id")
    private UserEntity createdByAdmin;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}