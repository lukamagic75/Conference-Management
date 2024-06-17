package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.DepartmentDTO;
import com.example.newconferencemanagement.exception.DepartmentNotFoundException;
import com.example.newconferencemanagement.model.Department;
import com.example.newconferencemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门服务类，处理部门相关的业务逻辑
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(DepartmentDTO::new)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return new DepartmentDTO(department);
    }

    public void createDepartment(DepartmentDTO departmentDTO) {
        departmentRepository.save(departmentDTO.toEntity());
    }

    public void updateDepartment(Long id, DepartmentDTO departmentDTO) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.save(departmentDTO.toEntity());
        } else {
            throw new DepartmentNotFoundException("Department not found");
        }
    }

    public void deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new DepartmentNotFoundException("Department not found");
        }
    }
}
