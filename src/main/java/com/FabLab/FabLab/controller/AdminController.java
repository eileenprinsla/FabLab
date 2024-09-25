package com.FabLab.FabLab.controller;

import com.FabLab.FabLab.dto.LoginDetail;
import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private AdminService adminService;

    @PostMapping("/admin/register")
    public void RegisterAdmin(@RequestBody Admin admin) {

        adminService.CreateAdmin(admin);
    }

    @PostMapping("/admin/authenticate")
    public void LoginAdmin(@RequestBody LoginDetail loginDetail) {

        adminService.LoginAdmin(loginDetail.getEmail(), loginDetail.getPassword());
    }

}
