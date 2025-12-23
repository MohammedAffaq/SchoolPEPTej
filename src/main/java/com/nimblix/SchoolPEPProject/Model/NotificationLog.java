package com.nimblix.SchoolPEPProject.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long assignmentId;

    private String channel;

    @Column(length = 500)
    private String message;

    private LocalDateTime sentAt;
}
