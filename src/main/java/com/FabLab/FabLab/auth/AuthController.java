package com.FabLab.FabLab.auth;

import com.FabLab.FabLab.dto.LoginDetail;
import com.FabLab.FabLab.entity.Admin;
import com.FabLab.FabLab.entity.Techie;
import com.FabLab.FabLab.entity.Users;
import com.FabLab.FabLab.service.AdminService;
import com.FabLab.FabLab.service.TechieService;
import com.FabLab.FabLab.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {


    private final AdminService adminService;
    private final UserService userService;
    private final TechieService techieService;

    public AuthController(AdminService adminService, UserService userService, TechieService techieService) {
        this.adminService = adminService;
        this.userService = userService;
        this.techieService = techieService;
    }

    @PostMapping("/admin/register")
    public Admin RegisterAdmin(@RequestBody Admin admin) {
        return adminService.CreateAdmin(admin);
    }

    @PostMapping("/user/register")
    public Users RegisterUser(@RequestBody Users user) {
        return userService.CreateUser(user);
    }

    @PostMapping("/techie/register")
    public Techie RegisterTechie(@RequestBody Techie techie) {
        return techieService.CreateAdmin(techie);
    }

    @PostMapping("/users/authenticate")
    public String LoginUser(@RequestBody LoginDetail loginDetail) {
        return  adminService.LoginAdmin(loginDetail.getEmail(), loginDetail.getPassword());
    }

}
