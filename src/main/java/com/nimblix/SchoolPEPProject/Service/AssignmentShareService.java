package com.nimblix.SchoolPEPProject.Service;

import com.nimblix.SchoolPEPProject.Request.AssignmentShareRequest;

import java.util.Map;

public interface AssignmentShareService {

    Map<String, String> shareAssignment(
            Long assignmentId,
            AssignmentShareRequest request);
}
