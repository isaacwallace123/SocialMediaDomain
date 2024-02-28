package org.isaacwallace.socialmedia.Users.Presentation;

import lombok.Data;

import java.util.Date;
@Data
public class UserResponseModel {
    private String userid;

    private String first_name;
    private String last_name;

    private String username;
    private String email;

    private String bio;
    private Date joined_date;

    private String postal_code;
    private String street;
    private String city;
    private String province;
    private String country;
}