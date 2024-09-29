package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.dto.LoginDetail;
import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin/register")
    public Admin RegisterAdmin(@RequestBody Admin admin) {
        return adminService.CreateAdmin(admin);
    }

    @PostMapping("/users/authenticate")
    public String LoginUser(@RequestBody LoginDetail loginDetail) {
      return  adminService.LoginAdmin(loginDetail.getEmail(), loginDetail.getPassword());
    }

}
