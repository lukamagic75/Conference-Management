package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.TenantDTO;
import com.example.newconferencemanagement.model.Tenant;
import com.example.newconferencemanagement.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public List<TenantDTO> getAllTenants() {
        return tenantRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TenantDTO getTenantById(Long id) {
        return tenantRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public TenantDTO createTenant(TenantDTO tenantDTO) {
        Tenant tenant = convertToEntity(tenantDTO);
        tenant = tenantRepository.save(tenant);
        return convertToDTO(tenant);
    }

    public TenantDTO updateTenant(Long id, TenantDTO tenantDTO) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new RuntimeException("Tenant not found"));
        tenant.setTenantName(tenantDTO.getTenantName());
        tenant.setContactInfo(tenantDTO.getContactInfo());
        tenant.setPassword(tenantDTO.getPassword());
        tenant.setEmail(tenantDTO.getEmail());
        tenant.setPhoneNumber(tenantDTO.getPhoneNumber());
        tenant.setGender(tenantDTO.getGender());
        tenant.setRole(tenantDTO.getRole());
        tenant = tenantRepository.save(tenant);
        return convertToDTO(tenant);
    }

    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }

    public TenantDTO authenticate(String tenantName, String password) {
        Tenant tenant = tenantRepository.findByTenantName(tenantName);
        if (tenant != null && tenant.getPassword().equals(password)) {
            return convertToDTO(tenant);
        }
        return null;
    }

    private TenantDTO convertToDTO(Tenant tenant) {
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setId(tenant.getId());
        tenantDTO.setTenantName(tenant.getTenantName());
        tenantDTO.setContactInfo(tenant.getContactInfo());
        tenantDTO.setPassword(tenant.getPassword());
        tenantDTO.setEmail(tenant.getEmail());
        tenantDTO.setPhoneNumber(tenant.getPhoneNumber());
        tenantDTO.setGender(tenant.getGender());
        tenantDTO.setRole(tenant.getRole());
        return tenantDTO;
    }

    private Tenant convertToEntity(TenantDTO tenantDTO) {
        Tenant tenant = new Tenant();
        tenant.setId(tenantDTO.getId());
        tenant.setTenantName(tenantDTO.getTenantName());
        tenant.setContactInfo(tenantDTO.getContactInfo());
        tenant.setPassword(tenantDTO.getPassword());
        tenant.setEmail(tenantDTO.getEmail());
        tenant.setPhoneNumber(tenantDTO.getPhoneNumber());
        tenant.setGender(tenantDTO.getGender());
        tenant.setRole(tenantDTO.getRole());
        return tenant;
    }
}
