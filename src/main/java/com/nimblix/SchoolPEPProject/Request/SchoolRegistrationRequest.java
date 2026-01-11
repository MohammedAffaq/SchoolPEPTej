//package com.nimblix.SchoolPEPProject.Request;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class SchoolRegistrationRequest {
//
//    private Long schoolId;
//    private String schoolName;
//    private String schoolAddress;
//    private String schoolPhone;
//    private String schoolEmail;
//    private Double latitude;
//    private Double longitude;
//    private String password;
//
//    // GPS / MANUAL
//    private String locationType;
//}

package com.nimblix.SchoolPEPProject.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRegistrationRequest {

    // Basic school details
    private String schoolName;
    private String schoolId;          // Must be UNIQUE
    private String email;             // Must be UNIQUE

    // Password details
    private String password;
    private String confirmPassword;

    // Contact & address details
    private String address;
    private String mobileNumber;      // Must be 10 digits
    private String city;
    private String state;
    private String pincode;
}

