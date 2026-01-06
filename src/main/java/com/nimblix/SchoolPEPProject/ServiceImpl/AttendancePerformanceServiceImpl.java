package com.nimblix.SchoolPEPProject.ServiceImpl;

import com.nimblix.SchoolPEPProject.Service.AttendancePerformanceService;
import com.nimblix.SchoolPEPProject.dto.AttendanceDayDTO;
import com.nimblix.SchoolPEPProject.dto.AttendancePerformanceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendancePerformanceServiceImpl
    implements AttendancePerformanceService {

    @Override
    public AttendancePerformanceResponse getAttendancePerformance(
        Long studentId, String week) {

        List<AttendanceDayDTO> days = new ArrayList<>();

        days.add(new AttendanceDayDTO("Mon", true));
        days.add(new AttendanceDayDTO("Tue", true));
        days.add(new AttendanceDayDTO("Wed", false));
        days.add(new AttendanceDayDTO("Thu", true));
        days.add(new AttendanceDayDTO("Fri", true));

        int present = 0;
        for (AttendanceDayDTO d : days) {
            if (d.isPresent()) {
                present++;
            }
        }

        int percentage = (present * 100) / days.size();

        return new AttendancePerformanceResponse(percentage, days);
    }
}
