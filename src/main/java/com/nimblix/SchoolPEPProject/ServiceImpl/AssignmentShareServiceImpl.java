package com.nimblix.SchoolPEPProject.ServiceImpl;

import com.nimblix.SchoolPEPProject.Constants.SchoolConstants;
import com.nimblix.SchoolPEPProject.Model.Assignments;
import com.nimblix.SchoolPEPProject.Model.AssignmentShareLog;
import com.nimblix.SchoolPEPProject.Model.Student;
import com.nimblix.SchoolPEPProject.Repository.AssignmentRepository;
import com.nimblix.SchoolPEPProject.Repository.AssignmentShareLogRepository;
import com.nimblix.SchoolPEPProject.Repository.StudentRepository;
import com.nimblix.SchoolPEPProject.Request.AssignmentShareRequest;
import com.nimblix.SchoolPEPProject.Service.AssignmentShareService;
import com.nimblix.SchoolPEPProject.Notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AssignmentShareServiceImpl implements AssignmentShareService {

    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final AssignmentShareLogRepository assignmentShareLogRepository;
    private final NotificationService notificationService;

    @Override
    public Map<String, String> shareAssignment(
            Long assignmentId,
            AssignmentShareRequest request) {

        Map<String, String> response = new HashMap<>();

        if (assignmentId == null || assignmentId <= 0) {
            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_ERORR);
            response.put(SchoolConstants.MESSAGE, "Assignment ID is required");
            return response;
        }

        if (request.getClassId() == null) {
            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_ERORR);
            response.put(SchoolConstants.MESSAGE, "classId is required");
            return response;
        }

        if (request.getShareChannels() == null || request.getShareChannels().isEmpty()) {
            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_ERORR);
            response.put(SchoolConstants.MESSAGE, "At least one share channel is required");
            return response;
        }

        Optional<Assignments> assignmentOptional =
                assignmentRepository.findById(assignmentId);

        if (assignmentOptional.isEmpty()) {
            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_ERORR);
            response.put(SchoolConstants.MESSAGE, "Assignment not found");
            return response;
        }

        Assignments assignment = assignmentOptional.get();

        List<Student> students = studentRepository
                .findByClassIdAndSectionId(
                        request.getClassId(),
                        request.getSectionId());

        if (students == null || students.isEmpty()) {
            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_ERORR);
            response.put(SchoolConstants.MESSAGE,
                    "No students found for the given class and section");
            return response;
        }

        for (Student student : students) {
            notificationService.notifyStudent(
                    student,
                    assignment,
                    request.getShareChannels()
            );
        }

        assignment.setShared(true);
        assignmentRepository.save(assignment);

        AssignmentShareLog log = new AssignmentShareLog();
        log.setAssignmentId(assignmentId);
        log.setClassId(request.getClassId());
        log.setSectionId(request.getSectionId());
        log.setChannels(request.getShareChannels());

        assignmentShareLogRepository.save(log);

        response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
        response.put(SchoolConstants.MESSAGE,
                "Assignment shared successfully with students");

        return response;
    }
}
