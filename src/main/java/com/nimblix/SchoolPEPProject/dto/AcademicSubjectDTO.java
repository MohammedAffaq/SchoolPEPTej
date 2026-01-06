package com.nimblix.SchoolPEPProject.dto;

public class AcademicSubjectDTO {
    private String subject;
    private int percentage;

    public AcademicSubjectDTO(String subject, int percentage) {
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getSubject() {
        return subject;
    }

    public int getPercentage() {
        return percentage;
    }
}
