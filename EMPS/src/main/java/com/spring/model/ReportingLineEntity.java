package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reporting_lines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportingLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private UserEntity manager;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subordinate_id", nullable = false)
    private UserEntity subordinate;
    
    @Column(name = "is_primary")
    private Boolean isPrimary = true;
    
    @Column(name = "effective_from")
    private LocalDate effectiveFrom;
    
    @Column(name = "effective_to")
    private LocalDate effectiveTo;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}