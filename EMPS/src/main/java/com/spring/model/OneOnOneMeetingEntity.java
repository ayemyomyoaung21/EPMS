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
@Table(name = "one_on_one_meetings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OneOnOneMeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private UserEntity manager;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private UserEntity employee;
    
    @Column(name = "meeting_date", nullable = false)
    private LocalDateTime meetingDate;
    
    @Column(name = "duration_minutes")
    private Integer durationMinutes = 30;
    
    @Column(length = 255)
    private String location;
    
    @Column(name = "discussion_topics", columnDefinition = "TEXT")
    private String discussionTopics;
    
    @Column(name = "decisions_made", columnDefinition = "TEXT")
    private String decisionsMade;
    
    @Column(name = "action_items", columnDefinition = "json")
    private String actionItems;
    
    @Column(name = "attendance_status", length = 20)
    private String attendanceStatus = "SCHEDULED";
    
    @Column(name = "next_meeting_date")
    private LocalDateTime nextMeetingDate;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}