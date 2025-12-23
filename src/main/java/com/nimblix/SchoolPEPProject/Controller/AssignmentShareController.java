package com.nimblix.SchoolPEPProject.Controller;


import com.nimblix.SchoolPEPProject.Request.AssignmentShareRequest;
import com.nimblix.SchoolPEPProject.Response.AssignmentRespone;
import com.nimblix.SchoolPEPProject.Service.AssignmentShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentShareController {

    private final AssignmentShareService assignmentShareService;

    @PostMapping("/{assignmentId}/share")
    public Map<String, String> shareAssignment(
            @PathVariable Long assignmentId,
            @RequestBody AssignmentShareRequest request) {

        return assignmentShareService
                .shareAssignment(assignmentId, request);
    }
}



