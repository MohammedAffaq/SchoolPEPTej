package com.nimblix.SchoolPEPProject.Service;

import com.nimblix.SchoolPEPProject.Request.SchoolRegistrationRequest;

public interface SchoolService {

    /**
     * Register a new school
     * @param request School registration details
     */
    void registerSchool(SchoolRegistrationRequest request);
}
