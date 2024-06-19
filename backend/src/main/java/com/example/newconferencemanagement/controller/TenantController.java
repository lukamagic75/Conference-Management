package com.example.newconferencemanagement.controller;

import com.example.newconferencemanagement.dto.TenantDTO;
import com.example.newconferencemanagement.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 租户控制器类，处理租户相关的HTTP请求
 */
@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping
    public List<TenantDTO> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @GetMapping("/{id}")
    public TenantDTO getTenantById(@PathVariable Long id) {
        return tenantService.getTenantById(id);
    }

    @PostMapping
    public void createTenant(@RequestBody TenantDTO tenantDTO) {
        tenantService.createTenant(tenantDTO);
    }

    @PutMapping("/{id}")
    public void updateTenant(@PathVariable Long id, @RequestBody TenantDTO tenantDTO) {
        tenantService.updateTenant(id, tenantDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
    }
}
