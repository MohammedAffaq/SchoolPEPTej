package com.nimblix.SchoolPEPProject.dto;

import java.util.List;

public class AcademicPerformanceResponse {
    private int averagePercentage;
    private List<AcademicSubjectDTO> subjects;

    public AcademicPerformanceResponse(int averagePercentage, List<AcademicSubjectDTO> subjects) {
        this.averagePercentage = averagePercentage;
        this.subjects = subjects;
    }

    public int getAveragePercentage() {
        return averagePercentage;
    }

    public List<AcademicSubjectDTO> getSubjects() {
        return subjects;
    }
}
