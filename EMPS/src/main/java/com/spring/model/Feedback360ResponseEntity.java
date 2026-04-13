package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_360_responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback360ResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_record_id", nullable = false)
    private Feedback360ProviderEntity providerRecord;
    
    @Column(columnDefinition = "json")
    private String ratings;
    
    @Column(name = "additional_comments", columnDefinition = "TEXT")
    private String additionalComments;
    
    @Column(columnDefinition = "TEXT")
    private String comments;
    
    @CreationTimestamp
    @Column(name = "submitted_at", updatable = false)
    private LocalDateTime submittedAt;
}