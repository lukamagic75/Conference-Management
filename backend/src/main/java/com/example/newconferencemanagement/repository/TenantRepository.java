package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 租户仓库接口，提供基本的CRUD操作
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
