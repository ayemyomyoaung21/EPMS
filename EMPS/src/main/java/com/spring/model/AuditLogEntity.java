package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @Column(nullable = false, length = 50)
    private String action;
    
    @Column(nullable = false, length = 50)
    private String module;
    
    @Column(name = "record_id")
    private Long recordId;
    
    @Column(name = "old_value", columnDefinition = "LONGTEXT")
    private String oldValue;
    
    @Column(name = "new_value", columnDefinition = "LONGTEXT")
    private String newValue;
    
    @Column(columnDefinition = "TEXT")
    private String reason;
    
    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;
    
    @CreationTimestamp
    @Column(name = "timestamp", updatable = false)
    private LocalDateTime timestamp;
}