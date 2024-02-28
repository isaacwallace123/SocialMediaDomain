package org.isaacwallace.socialmedia.Admins.Presentation.Models;

import lombok.Data;
import org.isaacwallace.socialmedia.Admins.DataAccess.Position;
import org.isaacwallace.socialmedia.Common.Objects.Address;
import org.isaacwallace.socialmedia.Common.Objects.PhoneNumber;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class AdminResponseModel extends RepresentationModel<AdminResponseModel> {
    private String adminid;
    private String first_name;
    private String last_name;
    private String email;
    private Double salary;
    private Address address;
    private List<PhoneNumber> phoneNumbers;
    private Position position;
}
