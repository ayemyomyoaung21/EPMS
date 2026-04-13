package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "staff_no", unique = true, nullable = false, length = 50)
    private String staffNo;
    
    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;
    
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    
    @Column(name = "staff_name", nullable = false, length = 100)
    private String staffName;
    
    @Column(name = "nrc_no", length = 50)
    private String nrcNo;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Column(name = "contact_address", columnDefinition = "TEXT")
    private String contactAddress;
    
    @Column(name = "permanent_address", columnDefinition = "TEXT")
    private String permanentAddress;
    
    @Column(name = "marital_status", length = 20)
    private String maritalStatus;
    
    @Column(length = 50)
    private String nationality;
    
    @Column(name = "phone_no", length = 20)
    private String phoneNo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "staff_type", length = 20)
    private StaffType staffType;
    
    @Column(name = "date_of_appointment")
    private LocalDate dateOfAppointment;
    
    @Column(name = "date_of_confirmation")
    private LocalDate dateOfConfirmation;
    
    @Column(name = "date_of_promotion")
    private LocalDate dateOfPromotion;
    
    @Column(name = "profile_image_url", columnDefinition = "TEXT")
    private String profileImageUrl;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    
    @Column(name = "failed_login_attempts")
    private Integer failedLoginAttempts = 0;
    
    @Column(name = "locked_until")
    private LocalDateTime lockedUntil;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private PositionEntity position;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}