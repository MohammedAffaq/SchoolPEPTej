package com.nimblix.SchoolPEPProject.Repository;

import com.nimblix.SchoolPEPProject.Model.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentsRepository extends JpaRepository<Attachments, Long> {

    // attachmentId + assignmentId validation
    Optional<Attachments> findByIdAndTask_Id(
            Long attachmentId,
            Long taskId
    );
}
