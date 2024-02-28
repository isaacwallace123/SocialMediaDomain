package org.isaacwallace.socialmedia.Admin.Business;

import org.isaacwallace.socialmedia.Admin.DataAccess.Admin;
import org.isaacwallace.socialmedia.Admin.DataAccess.AdminRepository;
import org.isaacwallace.socialmedia.Admin.Presentation.AdminResponseModel;
import org.isaacwallace.socialmedia.Utils.Exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminResponseModel> getAllAdmins() {
        List<AdminResponseModel> DTOS = new ArrayList<AdminResponseModel>();
        /*List<Admin> Employees = this.adminRepository.findAll();

        Employees.forEach(employee -> {
            EmployeeResponseDTO DTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employee, DTO);
            DTO.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
            DTOS.add(DTO);
        });*/

        return DTOS;
    }

    public AdminResponseModel getAdminById(String adminid) {
        Admin admin = this.adminRepository.findAdminByAdminIdentifier_Adminid(adminid);

        if (admin == null) {
            throw new NotFoundException("Unknown employee id: " + adminid);
        }

        AdminResponseModel DTO = new AdminResponseModel();
        BeanUtils.copyProperties(admin, DTO);

        return DTO;
    }
}
