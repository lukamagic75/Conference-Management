package com.example.newconferencemanagement.model;

import javax.persistence.Entity;

@Entity
public class Tenant extends User {
    private String tenantName;
    private String contactInfo;

    // Getters and Setters
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
