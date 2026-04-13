package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "pip_meetings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PipMeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pip_id", nullable = false)
    private PerformanceImprovementPlanEntity pip;
    
    @Column(name = "meeting_date", nullable = false)
    private LocalDateTime meetingDate;
    
    @Column(length = 255)
    private String location;
    
    @Column(columnDefinition = "TEXT")
    private String agenda;
    
    @Column(name = "meeting_notes", columnDefinition = "TEXT")
    private String meetingNotes;
    
    @Column(length = 20)
    private String status = "SCHEDULED";
    
    @Column(name = "reminder_sent_at")
    private LocalDateTime reminderSentAt;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}