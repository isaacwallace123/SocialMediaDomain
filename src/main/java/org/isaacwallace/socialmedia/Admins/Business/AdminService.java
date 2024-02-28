package org.isaacwallace.socialmedia.Admins.Business;

import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminRequestModel;
import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminResponseModel;

import java.util.List;

public interface AdminService {
    public List<AdminResponseModel> getAllAdmins();
    public AdminResponseModel getAdminById(String userid);
    public AdminResponseModel addAdmin(AdminRequestModel adminRequestModel);
    public AdminResponseModel editAdmin(String userid, AdminRequestModel adminRequestModel);
    public void deleteAdmin(String userid);
}
