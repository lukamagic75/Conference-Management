package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.TenantDTO;
import com.example.newconferencemanagement.exception.TenantNotFoundException;
import com.example.newconferencemanagement.model.Tenant;
import com.example.newconferencemanagement.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 租户服务类，处理租户相关的业务逻辑
 */
@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public List<TenantDTO> getAllTenants() {
        return tenantRepository.findAll().stream()
                .map(TenantDTO::new)
                .collect(Collectors.toList());
    }

    public TenantDTO getTenantById(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new TenantNotFoundException("Tenant not found"));
        return new TenantDTO(tenant);
    }

    public void createTenant(TenantDTO tenantDTO) {
        tenantRepository.save(tenantDTO.toEntity());
    }

    public void updateTenant(Long id, TenantDTO tenantDTO) {
        if (tenantRepository.existsById(id)) {
            tenantRepository.save(tenantDTO.toEntity());
        } else {
            throw new TenantNotFoundException("Tenant not found");
        }
    }

    public void deleteTenant(Long id) {
        if (tenantRepository.existsById(id)) {
            tenantRepository.deleteById(id);
        } else {
            throw new TenantNotFoundException("Tenant not found");
        }
    }
}
