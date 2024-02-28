package org.isaacwallace.socialmedia.Admins.Presentation;

import org.isaacwallace.socialmedia.Admins.Business.AdminService;
import org.isaacwallace.socialmedia.Admins.Presentation.Models.AdminResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public ResponseEntity<List<AdminResponseModel>> GetAdmins() {
        return ResponseEntity.status(HttpStatus.OK).body(this.adminService.getAllAdmins());
    }

    @GetMapping("{adminid}")
    public ResponseEntity<AdminResponseModel> GetAdminById(@PathVariable String adminid) {
        return ResponseEntity.status(HttpStatus.OK).body(this.adminService.getAdminById(adminid));
    }
}
