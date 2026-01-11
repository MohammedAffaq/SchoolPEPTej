package com.nimblix.SchoolPEPProject.Repository;

import com.nimblix.SchoolPEPProject.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    // Check if schoolId already exists
    boolean existsBySchoolId(Long schoolId);

    // Check if email already exists
    boolean existsBySchoolEmail(String schoolEmail);

    // Fetch school by schoolId
    Optional<School> findBySchoolId(Long schoolId);
}
