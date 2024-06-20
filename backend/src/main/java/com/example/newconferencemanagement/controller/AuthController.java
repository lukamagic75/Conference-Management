package com.example.newconferencemanagement.controller;

import com.example.newconferencemanagement.dto.AdminDTO;
import com.example.newconferencemanagement.dto.TenantDTO;
import com.example.newconferencemanagement.service.AdminService;
import com.example.newconferencemanagement.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TenantService tenantService;

    @PostMapping("/login/admin")
    public ResponseEntity<?> loginAdmin(@RequestParam String username, @RequestParam String password) {
        AdminDTO adminDTO = adminService.authenticate(username, password);
        if (adminDTO != null) {
            return ResponseEntity.ok(adminDTO);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/login/tenant")
    public ResponseEntity<?> loginTenant(@RequestParam String tenantName, @RequestParam String password) {
        TenantDTO tenantDTO = tenantService.authenticate(tenantName, password);
        if (tenantDTO != null) {
            return ResponseEntity.ok(tenantDTO);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register/tenant")
    public TenantDTO registerTenant(@RequestBody TenantDTO tenantDTO) {
        return tenantService.createTenant(tenantDTO);
    }
}
