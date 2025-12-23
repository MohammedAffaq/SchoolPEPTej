package com.nimblix.SchoolPEPProject.Request;

import lombok.Data;
import java.util.List;

@Data
public class AssignmentShareRequest {

    private Long classId;
    private Long sectionId;
    private List<String> shareChannels; // APP, EMAIL, NOTIFICATION
}
