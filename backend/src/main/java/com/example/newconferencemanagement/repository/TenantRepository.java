package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Tenant findByTenantName(String tenantName);
}
