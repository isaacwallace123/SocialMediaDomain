package org.isaacwallace.socialmedia.Users.Presentation.Models;

import lombok.Data;
import org.isaacwallace.socialmedia.Common.Objects.Address;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
@Data
public class UserResponseModel extends RepresentationModel<UserResponseModel> {
    private String userid;

    private String first_name;
    private String last_name;

    private String username;
    private String email;

    private String bio;
    private Date joined_date;

    private Address address;
}