package org.isaacwallace.socialmedia.Admin.Business;

import org.isaacwallace.socialmedia.Admin.DataAccess.Admin;
import org.isaacwallace.socialmedia.Admin.DataAccess.AdminRepository;
import org.isaacwallace.socialmedia.Admin.Presentation.AdminResponseModel;
import org.isaacwallace.socialmedia.Users.Presentation.UserResponseModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<UserResponseModel> getAllAdmins() {
        List<AdminResponseModel> DTOS = new ArrayList<AdminResponseModel>();
        List<Admin> Employees = this.adminRepository.findAll();

        Employees.forEach(employee -> {
            EmployeeResponseDTO DTO = new EmployeeResponseDTO();
            BeanUtils.copyProperties(employee, DTO);
            DTO.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());
            DTOS.add(DTO);
        });

        return DTOS;
    }

    public UserResponseModel getAdminById(String adminid) {
        Employee employee = employeeRepository.findEmployeeByEmployeeIdentifier_EmployeeId(employeeId);

        if (employee == null) {
            throw new NotFoundException("Unknown employee id: " + employeeId);
        }

        EmployeeResponseDTO DTO = new EmployeeResponseDTO();
        BeanUtils.copyProperties(employee, DTO);
        DTO.setEmployeeId(employee.getEmployeeIdentifier().getEmployeeId());

        return DTO;
    }
}
