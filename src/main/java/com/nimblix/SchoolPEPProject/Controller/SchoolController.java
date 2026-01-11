package com.nimblix.SchoolPEPProject.Controller;

import com.nimblix.SchoolPEPProject.Service.SchoolService;
import com.nimblix.SchoolPEPProject.Request.SchoolRegistrationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    /**
     * School Signup API
     */
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> registerSchool(
            @RequestBody SchoolRegistrationRequest request) {

        schoolService.registerSchool(request);

        Map<String, Object> response = new HashMap<>();
        response.put("status", 201);
        response.put("message", "School registered successfully");
        response.put("schoolId", request.getSchoolId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
