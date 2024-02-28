package org.isaacwallace.socialmedia.Admins.Business;

import org.isaacwallace.socialmedia.Admins.DataAccess.Admin;
import org.isaacwallace.socialmedia.Admins.DataAccess.AdminIdentifier;
import org.isaacwallace.socialmedia.Admins.DataAccess.AdminRepository;
import org.isaacwallace.socialmedia.Admins.Mapper.AdminRequestMapper;
import org.isaacwallace.socialmedia.Admins.Mapper.AdminResponseMapper;
import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminRequestModel;
import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminResponseModel;
import org.isaacwallace.socialmedia.Users.DataAccess.User;
import org.isaacwallace.socialmedia.Users.DataAccess.UserIdentifier;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserRequestModel;
import org.isaacwallace.socialmedia.Users.Presentation.Models.UserResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InUseException;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminRequestMapper adminRequestMapper;
    private final AdminResponseMapper adminResponseMapper;

    public AdminServiceImpl(AdminRepository adminRepository, AdminRequestMapper adminRequestMapper, AdminResponseMapper adminResponseMapper) {
        this.adminRepository = adminRepository;
        this.adminRequestMapper = adminRequestMapper;
        this.adminResponseMapper = adminResponseMapper;
    }

    public List<AdminResponseModel> getAllAdmins() {
        return this.adminResponseMapper.entityListToResponseModelList(this.adminRepository.findAll());
    }

    public AdminResponseModel getAdminById(String adminid) {
        Admin admin = this.adminRepository.findAdminByAdminIdentifier_Adminid(adminid);

        if (admin == null) {
            throw new InvalidInputException("Unknown userId: " + adminid);
        }

        return this.adminResponseMapper.entityToResponseModel(admin);
    }

    public AdminResponseModel addAdmin(AdminRequestModel adminRequestModel) {
        Admin newAdmin = this.adminRequestMapper.requestModelToEntity(adminRequestModel, new AdminIdentifier());

        return this.adminResponseMapper.entityToResponseModel(newAdmin);
    }

    public AdminResponseModel editAdmin(String adminid, AdminRequestModel adminRequestModel) {
        Admin admin = this.adminRepository.findAdminByAdminIdentifier_Adminid(adminid);

        if (admin == null) {
            throw new InvalidInputException("Unknown adminid: " + adminid);
        }

        Admin updatedAdmin = this.adminRequestMapper.requestModelToEntity(adminRequestModel, admin.getAdminIdentifier());

        this.adminRepository.save(updatedAdmin);

        return this.adminResponseMapper.entityToResponseModel(updatedAdmin);
    }

    public void deleteAdmin(String adminid) {
        Admin admin = this.adminRepository.findAdminByAdminIdentifier_Adminid(adminid);

        if (admin == null) {
            throw new InvalidInputException("Unknown adminid: " + adminid);
        }

        try {
            this.adminRepository.delete(admin);
        } catch(DataIntegrityViolationException exception) {
            throw new InUseException("Admin is in use by another entity, currently cannot delete.");
        }
    }
}
