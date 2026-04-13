package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_360_providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback360ProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewee_id", nullable = false)
    private UserEntity reviewee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private UserEntity provider;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle_id", nullable = false)
    private Feedback360CycleEntity cycle;
    
    @Column(name = "provider_role", nullable = false, length = 20)
    private String providerRole;
    
    @Column(name = "is_anonymous")
    private Boolean isAnonymous = true;
    
    @Column(length = 20)
    private String status = "PENDING";
    
    @Column(name = "invitation_sent_at")
    private LocalDateTime invitationSentAt;
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;
}