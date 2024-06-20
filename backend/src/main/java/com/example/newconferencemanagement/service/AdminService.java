package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.AdminDTO;
import com.example.newconferencemanagement.model.Admin;
import com.example.newconferencemanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AdminDTO getAdminById(Long id) {
        return adminRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = convertToEntity(adminDTO);
        admin = adminRepository.save(admin);
        return convertToDTO(admin);
    }

    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        admin.setPhoneNumber(adminDTO.getPhoneNumber());
        admin.setGender(adminDTO.getGender());
        admin.setRole(adminDTO.getRole());
        admin = adminRepository.save(admin);
        return convertToDTO(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public AdminDTO authenticate(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return convertToDTO(admin);
        }
        return null;
    }

    private AdminDTO convertToDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPhoneNumber(admin.getPhoneNumber());
        adminDTO.setGender(admin.getGender());
        adminDTO.setRole(admin.getRole());
        return adminDTO;
    }

    private Admin convertToEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        admin.setPhoneNumber(adminDTO.getPhoneNumber());
        admin.setGender(adminDTO.getGender());
        admin.setRole(adminDTO.getRole());
        return admin;
    }
}
