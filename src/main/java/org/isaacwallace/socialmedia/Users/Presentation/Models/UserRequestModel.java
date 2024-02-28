package org.isaacwallace.socialmedia.Users.Presentation.Models;

import lombok.*;
import org.isaacwallace.socialmedia.Common.Objects.Address;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequestModel {
    String first_name;
    String last_name;

    String username;
    String email;

    String bio;
    Date joined_date;

    Address address;
}
