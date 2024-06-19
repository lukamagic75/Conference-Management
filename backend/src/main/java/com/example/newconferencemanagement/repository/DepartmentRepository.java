package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门仓库接口，提供基本的CRUD操作
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
