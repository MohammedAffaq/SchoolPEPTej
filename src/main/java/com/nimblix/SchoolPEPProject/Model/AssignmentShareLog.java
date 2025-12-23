package com.nimblix.SchoolPEPProject.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AssignmentShareLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // ✅ REQUIRED PRIMARY KEY

    private Long assignmentId;
    private Long classId;
    private Long sectionId;

    @ElementCollection
    @CollectionTable(
            name = "assignment_share_log_channels",
            joinColumns = @JoinColumn(name = "assignment_share_log_id")
    )
    @Column(name = "channel")
    private List<String> channels;
}
