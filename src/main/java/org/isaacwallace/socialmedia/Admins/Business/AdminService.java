package org.isaacwallace.socialmedia.Admins.Business;

import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminResponseModel;

import java.util.List;

public interface AdminService {
    public List<AdminResponseModel> getAllAdmins();
    public AdminResponseModel getAdminById(String userid);
}
