package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pip_tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PipTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objective_id", nullable = false)
    private PipObjectiveEntity objective;
    
    @Column(name = "action_item", nullable = false, columnDefinition = "TEXT")
    private String actionItem;
    
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;
    
    @Column(length = 20)
    private String status = "NOT_STARTED";
    
    @Column(name = "manager_notes", columnDefinition = "TEXT")
    private String managerNotes;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;
}