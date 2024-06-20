package com.example.newconferencemanagement.repository;

import com.example.newconferencemanagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
