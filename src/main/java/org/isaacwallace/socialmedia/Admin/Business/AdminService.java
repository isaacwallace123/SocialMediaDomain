package org.isaacwallace.socialmedia.Admin.Business;

import org.isaacwallace.socialmedia.Users.Presentation.UserResponseModel;

import java.util.List;

public interface AdminService {
    public List<UserResponseModel> getAllAdmins();
    public UserResponseModel getAdminById(String userid);
}
