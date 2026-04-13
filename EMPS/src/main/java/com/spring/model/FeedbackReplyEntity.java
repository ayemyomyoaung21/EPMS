package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_replies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id", nullable = false)
    private ContinuousFeedbackEntity feedback;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_by_id", nullable = false)
    private UserEntity replyBy;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    @CreationTimestamp
    @Column(name = "replied_at", updatable = false)
    private LocalDateTime repliedAt;
}