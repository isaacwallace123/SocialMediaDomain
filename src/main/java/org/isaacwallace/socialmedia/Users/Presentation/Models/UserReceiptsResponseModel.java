package org.isaacwallace.socialmedia.Users.Presentation.Models;

import lombok.Data;
import org.isaacwallace.socialmedia.Common.Objects.Address;
import org.isaacwallace.socialmedia.Receipts.Presentation.Models.ReceiptResponseModel;

import java.util.Date;
import java.util.List;

@Data
public class UserReceiptsResponseModel {
    private String userid;

    private String first_name;
    private String last_name;

    private String username;
    private String email;

    private String bio;
    private Date joined_date;

    private Address address;

    private List<ReceiptResponseModel> Receipts;
}
