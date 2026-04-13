package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "self_assessment_response_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelfAssessmentResponseDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id", nullable = false)
    private SelfAssessmentResponseEntity response;
    
    @Column(name = "question_number", nullable = false)
    private Integer questionNumber;
    
    @Column(name = "question_text", nullable = false, length = 500)
    private String questionText;
    
    @Column(name = "yes_no_value")
    private Boolean yesNoValue;
    
    @Column(name = "rating_value")
    private Integer ratingValue;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}