package com.example.newconferencemanagement.dto;

import com.example.newconferencemanagement.model.Tenant;

/**
 * 租户数据传输对象，用于在应用层和服务层之间传输数据
 */
public class TenantDTO {
    private Long id;
    private String tenantName;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private String status;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Tenant toEntity() {
        Tenant tenant = new Tenant();
        tenant.setId(this.id);
        tenant.setTenantName(this.tenantName);
        tenant.setContactPerson(this.contactPerson);
        tenant.setPhoneNumber(this.phoneNumber);
        tenant.setEmail(this.email);
        tenant.setStatus(this.status);
        return tenant;
    }

    public TenantDTO(Tenant tenant) {
        this.id = tenant.getId();
        this.tenantName = tenant.getTenantName();
        this.contactPerson = tenant.getContactPerson();
        this.phoneNumber = tenant.getPhoneNumber();
        this.email = tenant.getEmail();
        this.status = tenant.getStatus();
    }
}
