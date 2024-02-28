package org.isaacwallace.socialmedia.Admins.Business;

import org.isaacwallace.socialmedia.Admins.DataAccess.Admin;
import org.isaacwallace.socialmedia.Admins.DataAccess.AdminRepository;
import org.isaacwallace.socialmedia.Admins.Mapper.AdminRequestMapper;
import org.isaacwallace.socialmedia.Admins.Mapper.AdminResponseMapper;
import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.InvalidInputException;
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
}
