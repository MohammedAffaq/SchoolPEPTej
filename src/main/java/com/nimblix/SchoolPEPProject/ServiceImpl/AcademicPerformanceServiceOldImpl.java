//package com.nimblix.SchoolPEPProject.ServiceImpl;
//
//import com.nimblix.SchoolPEPProject.Service.AcademicPerformanceService_old;
//import com.nimblix.SchoolPEPProject.dto.AcademicPerformanceResponse;
//import com.nimblix.SchoolPEPProject.dto.AcademicSubjectDTO;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class AcademicPerformanceServiceOldImpl implements AcademicPerformanceService_old {
//
//    @Override
//    public AcademicPerformanceResponse getAcademicPerformance(
//        Long studentId, Integer year, String examType) {
//
//        List<AcademicSubjectDTO> subjects = new ArrayList<>();
//
//        subjects.add(new AcademicSubjectDTO("Tamil", 70));
//        subjects.add(new AcademicSubjectDTO("English", 75));
//        subjects.add(new AcademicSubjectDTO("Maths", 80));
//        subjects.add(new AcademicSubjectDTO("Science", 72));
//        subjects.add(new AcademicSubjectDTO("Social", 78));
//
//        int total = 0;
//        for (AcademicSubjectDTO s : subjects) {
//            total += s.getPercentage();
//        }
//
//        int average = total / subjects.size();
//
//        return new AcademicPerformanceResponse(average, subjects);
//    }
//}
