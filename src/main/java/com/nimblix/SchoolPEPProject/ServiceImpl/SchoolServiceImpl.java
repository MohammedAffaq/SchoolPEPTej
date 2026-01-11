package com.nimblix.SchoolPEPProject.ServiceImpl;

import com.nimblix.SchoolPEPProject.Constants.SchoolConstants;
import com.nimblix.SchoolPEPProject.Model.School;
import com.nimblix.SchoolPEPProject.Repository.SchoolRepository;
import com.nimblix.SchoolPEPProject.Request.SchoolRegistrationRequest;
import com.nimblix.SchoolPEPProject.Service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registerSchool(SchoolRegistrationRequest request) {

        // 1. Mandatory field validation
        if (request == null ||
                request.getSchoolName() == null ||
                request.getSchoolId() == null ||
                request.getEmail() == null ||
                request.getPassword() == null ||
                request.getConfirmPassword() == null ||
                request.getAddress() == null ||
                request.getMobileNumber() == null ||
                request.getCity() == null ||
                request.getState() == null ||
                request.getPincode() == null) {

            throw new IllegalArgumentException("All fields are mandatory");
        }

        // 2. Unique validations
        if (schoolRepository.existsBySchoolId(Long.valueOf(request.getSchoolId()))) {
            throw new RuntimeException("School already exists with this School ID");
        }

        if (schoolRepository.existsBySchoolEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // 3. Email format validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(emailRegex, request.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // 4. Mobile number validation
        if (!request.getMobileNumber().matches("\\d{10}")) {
            throw new IllegalArgumentException("Mobile number must be exactly 10 digits");
        }

        // 5. Password match validation
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException(
                    "Password and Confirm Password do not match"
            );
        }

        // 6. Password strength validation
        String passwordRegex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";

        if (!Pattern.matches(passwordRegex, request.getPassword())) {
            throw new IllegalArgumentException(
                    "Password must contain uppercase, lowercase, number, special character and minimum 8 characters"
            );
        }

        // 7. Encrypt password
        String encryptedPassword = passwordEncoder.encode(request.getPassword());

        // 8. Build entity
        School school = School.builder()
                .schoolId(Long.valueOf(request.getSchoolId()))
                .schoolName(request.getSchoolName())
                .schoolEmail(request.getEmail())
                .schoolAddress(request.getAddress())
                .password(encryptedPassword)
                .status(SchoolConstants.STATUS_ACTIVE)
                .isActive(true)
                .build();

        // 9. Save to DB
        schoolRepository.save(school);
    }
}
