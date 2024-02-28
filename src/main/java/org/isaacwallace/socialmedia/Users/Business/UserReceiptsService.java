package org.isaacwallace.socialmedia.Users.Business;

import org.isaacwallace.socialmedia.Users.Presentation.Models.UserReceiptsResponseModel;

public interface UserReceiptsService {
    public UserReceiptsResponseModel getAllReceiptsByUserId(String userid);
}
