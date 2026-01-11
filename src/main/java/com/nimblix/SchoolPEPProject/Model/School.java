package com.nimblix.SchoolPEPProject.Model;

import com.nimblix.SchoolPEPProject.Constants.SchoolConstants;
import com.nimblix.SchoolPEPProject.Util.SchoolUtil;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "school")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "school_address")
    private String schoolAddress;

    @Column(name = "school_phone")
    private String schoolPhone;

    @Column(name = "school_email", nullable = false, unique = true)
    private String schoolEmail;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "created_time", updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "subscription_status")
    private String subscriptionStatus;

    @Column(name = "trial_start_date")
    private LocalDateTime trialStartDate;

    @Column(name = "trial_end_date")
    private LocalDateTime trialEndDate;

    @Column(name = "is_active")
    private Boolean isActive;

    // ---------------- LIFECYCLE METHODS ----------------

    @PrePersist
    protected void onCreate() {
        this.createdTime = LocalDateTime.now();
        this.updatedTime = this.createdTime;

        this.emailVerified = false;
        this.subscriptionStatus = SchoolConstants.SUBSCRIPTION_TRAIL;
        this.trialStartDate = LocalDateTime.now();
        this.trialEndDate = LocalDateTime.now().plusDays(30);
        this.isActive = true;
        this.status = SchoolConstants.STATUS_ACTIVE;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedTime = LocalDateTime.now();
    }
}
