package com.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private UserEntity user;
    
    @Column(name = "staff_no", unique = true, nullable = false, length = 50)
    private String staffNo;
    
    @Column(name = "staff_name", nullable = false, length = 100)
    private String staffName;
    
    @Column(name = "other_name", length = 100)
    private String otherName;
    
    @Column(name = "staff_nrc_no", length = 50)
    private String staffNrcNo;
    
    @Column(length = 10)
    private String gender;
    
    @Column(length = 50)
    private String race;
    
    @Column(length = 50)
    private String religion;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Column(name = "birth_place", length = 100)
    private String birthPlace;
    
    @Column(name = "contact_address", columnDefinition = "TEXT")
    private String contactAddress;
    
    @Column(name = "permanent_address", columnDefinition = "TEXT")
    private String permanentAddress;
    
    @Column(name = "phone_no", length = 20)
    private String phoneNo;
    
    @Column(name = "email_address", nullable = false, length = 255)
    private String emailAddress;
    
    @Column(name = "marital_status", length = 20)
    private String maritalStatus;
    
    @Column(name = "spouse_name", length = 100)
    private String spouseName;
    
    @Column(name = "spouse_nrc_no", length = 50)
    private String spouseNrcNo;
    
    @Column(name = "father_name", length = 100)
    private String fatherName;
    
    @Column(name = "father_nrc_no", length = 50)
    private String fatherNrcNo;
    
    @Column(name = "father_occupation", length = 100)
    private String fatherOccupation;
    
    @Column(name = "spouse_occupation", length = 100)
    private String spouseOccupation;
    
    @Column(length = 100)
    private String department;
    
    @Column(name = "parent_department", length = 100)
    private String parentDepartment;
    
    @Column(name = "cost_allocate", length = 50)
    private String costAllocate;
    
    @Column(length = 100)
    private String position;
    
    @Column(name = "level_description", length = 10)
    private String levelDescription;
    
    @Column(length = 50)
    private String shift;
    
    @Column(name = "pay_type", length = 50)
    private String payType;
    
    @Column(name = "compliance_earned_points")
    private Integer complianceEarnedPoints = 0;
    
    @Column(name = "compliance_balance_points")
    private Integer complianceBalancePoints = 0;
    
    @Column(precision = 12, scale = 2)
    private BigDecimal salary;
    
    @Column(length = 10)
    private String currency = "Kyats";
    
    @Column(name = "date_of_termination")
    private LocalDate dateOfTermination;
    
    @Column(name = "date_of_demotion")
    private LocalDate dateOfDemotion;
    
    @Column(name = "date_of_transfer")
    private LocalDate dateOfTransfer;
    
    @Column(name = "date_of_salary_changed")
    private LocalDate dateOfSalaryChanged;
    
    @Column(name = "date_of_pay_type_changed")
    private LocalDate dateOfPayTypeChanged;
    
    @Column(name = "date_of_title_change")
    private LocalDate dateOfTitleChange;
    
    @Column(name = "date_of_currency_change")
    private LocalDate dateOfCurrencyChange;
    
    @Column(name = "work_permit_no", length = 50)
    private String workPermitNo;
    
    @Column(name = "work_permit_valid_date")
    private LocalDate workPermitValidDate;
    
    @Column(name = "work_permit_expire_date")
    private LocalDate workPermitExpireDate;
    
    @Column(name = "passport_no", length = 50)
    private String passportNo;
    
    @Column(name = "passport_expire_date")
    private LocalDate passportExpireDate;
    
    @Column(name = "labour_registration_no", length = 50)
    private String labourRegistrationNo;
    
    @Column(name = "tax_status", length = 20)
    private String taxStatus;
    
    @Column(name = "tax_no", length = 50)
    private String taxNo;
    
    @Column(name = "ssb_status", length = 20)
    private String ssbStatus;
    
    @Column(name = "sscb_no", length = 50)
    private String sscbNo;
    
    @Column(name = "probation_month")
    private Integer probationMonth = 3;
    
    @Column(name = "ace_internal_phone_no", length = 20)
    private String aceInternalPhoneNo;
    
    @Column(name = "permanent_phone_no", length = 20)
    private String permanentPhoneNo;
    
    @Column(name = "present_phone_no", length = 20)
    private String presentPhoneNo;
    
    @Column(name = "emergency_mobile_no", length = 20)
    private String emergencyMobileNo;
    
    @Column(name = "relation_with_emergency_mobile", length = 50)
    private String relationWithEmergencyMobile;
    
    @Column(name = "pay_by_backlog", length = 10)
    private String payByBacklog;
    
    @Column(name = "finger_print", length = 10)
    private String fingerPrint;
    
    @Column(name = "product_project", length = 100)
    private String productProject;
    
    @Column(name = "mobile_attendance", length = 10)
    private String mobileAttendance;
    
    @Column(name = "date_of_increment")
    private LocalDate dateOfIncrement;
    
    @Column(name = "date_of_appointment")
    private LocalDate dateOfAppointment;
    
    @Column(name = "date_of_confirmation")
    private LocalDate dateOfConfirmation;
    
    @Column(name = "date_of_promotion")
    private LocalDate dateOfPromotion;
    
    @Column(length = 50)
    private String nationality = "Burmese";
    
    @Column(name = "staff_type", length = 20)
    private String staffType;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}