package org.isaacwallace.socialmedia.Admin.Business;

import org.isaacwallace.socialmedia.Admin.Presentation.AdminResponseModel;

import java.util.List;

public interface AdminService {
    public List<AdminResponseModel> getAllAdmins();
    public AdminResponseModel getAdminById(String userid);
}
