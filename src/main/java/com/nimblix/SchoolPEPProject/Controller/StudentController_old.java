//package com.nimblix.SchoolPEPProject.Controller;
//
//import com.nimblix.SchoolPEPProject.Service.AcademicPerformanceService_old;
//import com.nimblix.SchoolPEPProject.Service.AttendancePerformanceService;
//import com.nimblix.SchoolPEPProject.dto.AcademicPerformanceResponse;
//import com.nimblix.SchoolPEPProject.dto.AttendancePerformanceResponse;
//
//import com.nimblix.SchoolPEPProject.Constants.SchoolConstants;
//import com.nimblix.SchoolPEPProject.Request.StudentRegistrationRequest;
//import com.nimblix.SchoolPEPProject.Response.StudentDetailsResponse;
//import com.nimblix.SchoolPEPProject.Service.StudentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/student")
//public class StudentController_old {
//    @Autowired
//    private AcademicPerformanceService_old academicPerformanceServiceOld;
//
//    @Autowired
//    private AttendancePerformanceService attendancePerformanceService;
//
//
//    private final StudentService studentService;
//
//    private final AcademicPerformanceService_old academicPerformanceServiceOld;
//    private final com.nimblix.SchoolPEPProject.service.AttendancePerformanceService attendancePerformanceService;
//
//
//
//    /*
//    In this API we are registering the student. It will help to onboard the student, In this we are storing the  student
//    fullName,emailId and password.
//     */
//    @PostMapping("/register")
//    public ResponseEntity<?> studentRegistration(@RequestBody StudentRegistrationRequest request) {
//        Map<String, Object> response = new HashMap<>();
//
//        try {
//            studentService.registerStudent(request);
//
//            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//            response.put(SchoolConstants.MESSAGE, "Student Registration Successful!");
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_FAILURE);
//            response.put(SchoolConstants.MESSAGE, e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//    }
//
// /*
//       This API is used to fetch the student details by using the student I'd.
// */
//
//    @GetMapping("/details")
//    public ResponseEntity<Map<String, Object>> getStudentsBySchoolId(
//            @RequestParam Long schoolId) {
//
//        List<StudentDetailsResponse> students =
//                studentService.getStudentsBySchoolId(schoolId);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//        response.put(SchoolConstants.MESSAGE, "Students fetched successfully");
//        response.put("data", students);
//
//        return ResponseEntity.ok(response);
//    }
//
//
//    @GetMapping("/list")
//    public ResponseEntity<?> getStudentList(
//            @RequestParam Long schoolId,
//            @RequestParam Long classId,
//            @RequestParam String section
//    ){
//        List<StudentDetailsResponse> students=studentService.getStudentsBySchoolClassAndSection(schoolId, classId, section);
//        Map<String, Object> response = new HashMap<>();
//        response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//        response.put("data", students);
//
//        return ResponseEntity.ok(response);
//    }
//
//
//    @PostMapping("/update")
//        public ResponseEntity<?> updateStudent(
//                @RequestParam Long studentId,
//                @RequestBody StudentRegistrationRequest request) {
//
//            Map<String, Object> response = new HashMap<>();
//
//            try {
//                studentService.updateStudentDetails(studentId, request);
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//                response.put(SchoolConstants.MESSAGE, "Student updated successfully");
//                return ResponseEntity.ok(response);
//
//            } catch (Exception e) {
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_FAILURE);
//                response.put(SchoolConstants.MESSAGE, e.getMessage());
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//            }
//        @GetMapping("/attendance-performance")
//        public ResponseEntity<AttendancePerformanceResponse> getAttendancePerformance(
//            @RequestParam Long studentId,
//            @RequestParam String week); {
//
//            return ResponseEntity.ok(
//                attendancePerformanceService.getAttendancePerformance(studentId, week)
//            );
//        }
//
//    }
//
//
//
//        @PostMapping("/delete")
//        public ResponseEntity<?> deleteStudent(@RequestParam Long studentId) {
//            Map<String, Object> response = new HashMap<>();
//
//            try {
//                studentService.deleteStudent(studentId);
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//                response.put(SchoolConstants.MESSAGE, "Student deleted successfully");
//                return ResponseEntity.ok(response);
//
//            } catch (Exception e) {
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_FAILURE);
//                response.put(SchoolConstants.MESSAGE, e.getMessage());
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//            }
//        }
//
//
//
//        @PutMapping("/update")
//        public ResponseEntity<?> updateStudentPut(
//                @RequestParam Long studentId,
//                @RequestBody StudentRegistrationRequest request) {
//
//            Map<String, Object> response = new HashMap<>();
//
//            try {
//                studentService.updateStudentDetails(studentId, request);
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//                response.put(SchoolConstants.MESSAGE, "Student updated successfully (PUT)");
//                return ResponseEntity.ok(response);
//
//            } catch (Exception e) {
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_FAILURE);
//                response.put(SchoolConstants.MESSAGE, e.getMessage());
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//            }
//        }
//
//
//
//        @DeleteMapping("/delete")
//        public ResponseEntity<?> deleteStudentDelete(@RequestParam Long studentId) {
//            Map<String, Object> response = new HashMap<>();
//
//            try {
//                studentService.deleteStudent(studentId);
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_SUCCESS);
//                response.put(SchoolConstants.MESSAGE, "Student deleted successfully (DELETE)");
//                return ResponseEntity.ok(response);
//
//            } catch (Exception e) {
//                response.put(SchoolConstants.STATUS, SchoolConstants.STATUS_FAILURE);
//                response.put(SchoolConstants.MESSAGE, e.getMessage());
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//            }
//        }
//    @GetMapping("/students/{studentId}/academic-score")
//    public AcademicPerformanceResponse getAcademicScore(
//        @PathVariable Long studentId,
//        @RequestParam int year) {
//
//        return academicPerformanceServiceOld
//            .getAcademicPerformance(studentId, year);
//        @GetMapping("/students/{studentId}/attendance-performance")
//        public AttendancePerformanceResponse getAttendancePerformance(
//            @PathVariable Long studentId,
//            @RequestParam String week) {
//
//            return attendancePerformanceService
//                .getAttendancePerformance(studentId, week);
//        }
//
//    }
//}
//
//
