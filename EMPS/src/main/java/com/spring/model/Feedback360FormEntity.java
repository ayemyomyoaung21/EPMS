package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_360_forms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback360FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private Integer version = 1;
    
    @Column(nullable = false, columnDefinition = "json")
    private String criteria;
    
    @Column(name = "rating_scale", columnDefinition = "json")
    private String ratingScale;
    
    @Column(name = "include_comments")
    private Boolean includeComments = true;
    
    @Column(name = "is_editable", nullable = false)
    private Boolean isEditable = true;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_admin_id")
    private UserEntity createdByAdmin;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}