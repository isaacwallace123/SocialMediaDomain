package org.isaacwallace.socialmedia.Admins.Presentation.Models;

import lombok.*;
import org.isaacwallace.socialmedia.Admins.DataAccess.Position;
import org.isaacwallace.socialmedia.Common.Objects.Address;
import org.isaacwallace.socialmedia.Common.Objects.PhoneNumber;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminRequestModel {
    String first_name;
    String last_name;
    String email;
    Double salary;
    Address address;
    List<PhoneNumber> phoneNumbers;
    Position position;
}
