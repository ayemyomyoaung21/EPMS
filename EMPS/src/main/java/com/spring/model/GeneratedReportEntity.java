package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "generated_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "generated_by_id", nullable = false)
    private UserEntity generatedBy;
    
    @Column(name = "report_type", nullable = false, length = 50)
    private String reportType;
    
    @Column(name = "filters_applied", columnDefinition = "json")
    private String filtersApplied;
    
    @Column(name = "file_path", nullable = false, columnDefinition = "TEXT")
    private String filePath;
    
    @Column(name = "file_size_bytes")
    private Long fileSizeBytes;
    
    @CreationTimestamp
    @Column(name = "generated_at", updatable = false)
    private LocalDateTime generatedAt;
}