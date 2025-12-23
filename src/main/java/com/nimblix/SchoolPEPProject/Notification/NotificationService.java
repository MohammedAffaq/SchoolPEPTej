package com.nimblix.SchoolPEPProject.Notification;

import com.nimblix.SchoolPEPProject.Model.Assignments;
import com.nimblix.SchoolPEPProject.Model.NotificationLog;
import com.nimblix.SchoolPEPProject.Model.Student;
import com.nimblix.SchoolPEPProject.Repository.NotificationLogRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationService.class);

    private final NotificationLogRepository notificationLogRepository;

    /**
     * Entry point used by AssignmentShareServiceImpl
     */
    public void notifyStudent(
            Student student,
            Assignments assignment,
            List<String> channels) {

        if (channels == null || channels.isEmpty()) {
            return;
        }

        for (String channel : channels) {

            if ("APP".equalsIgnoreCase(channel)) {
                sendInApp(student, assignment);
            }
            else if ("EMAIL".equalsIgnoreCase(channel)) {
                sendEmail(student, assignment);
            }
            else if ("NOTIFICATION".equalsIgnoreCase(channel)) {
                sendPush(student, assignment);
            }
        }
    }

    // ---------------- INTERNAL IMPLEMENTATION ----------------

    private void sendInApp(Student student, Assignments assignment) {

        log.info("In-App notification sent to studentId={}, assignmentId={}",
                student.getId(), assignment.getId());

        saveLog(student, assignment, "APP",
                "New assignment shared: " + assignment.getTitle());
    }

    private void sendEmail(Student student, Assignments assignment) {

        log.info("Email sent to {} for assignmentId={}",
                student.getEmail(), assignment.getId());

        saveLog(student, assignment, "EMAIL",
                "Assignment shared via email: " + assignment.getTitle());
    }

    private void sendPush(Student student, Assignments assignment) {

        log.info("Push notification sent to studentId={}, assignmentId={}",
                student.getId(), assignment.getId());

        saveLog(student, assignment, "NOTIFICATION",
                "New assignment notification: " + assignment.getTitle());
    }

    private void saveLog(
            Student student,
            Assignments assignment,
            String channel,
            String message) {

        NotificationLog logEntity = new NotificationLog();
        logEntity.setStudentId(student.getId());
        logEntity.setAssignmentId(assignment.getId());
        logEntity.setChannel(channel);
        logEntity.setMessage(message);
        logEntity.setSentAt(LocalDateTime.now());

        notificationLogRepository.save(logEntity);
    }
}
