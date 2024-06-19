package com.example.newconferencemanagement.dto;

import com.example.newconferencemanagement.model.Department;

/**
 * 部门数据传输对象，用于在应用层和服务层之间传输数据
 */
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String leader;
    private String email;
    private String status;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department toEntity() {
        Department department = new Department();
        department.setId(this.id);
        department.setDepartmentName(this.departmentName);
        department.setLeader(this.leader);
        department.setEmail(this.email);
        department.setStatus(this.status);
        return department;
    }

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
        this.leader = department.getLeader();
        this.email = department.getEmail();
        this.status = department.getStatus();
    }
}
