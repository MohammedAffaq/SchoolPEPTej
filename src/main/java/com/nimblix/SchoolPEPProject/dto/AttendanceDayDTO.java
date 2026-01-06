package com.nimblix.SchoolPEPProject.dto;

public class AttendanceDayDTO {
    private String day;
    private boolean present;

    public AttendanceDayDTO(String day, boolean present) {
        this.day = day;
        this.present = present;
    }

    public String getDay() {
        return day;
    }

    public boolean isPresent() {
        return present;
    }
}
