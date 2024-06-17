package com.example.newconferencemanagement.service;

import com.example.newconferencemanagement.dto.UserDTO;
import com.example.newconferencemanagement.exception.UserNotFoundException;
import com.example.newconferencemanagement.model.User;
import com.example.newconferencemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return new UserDTO(user);
    }

    public void createUser(UserDTO userDTO) {
        userRepository.save(userDTO.toEntity());
    }

    public void updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            userRepository.save(userDTO.toEntity());
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
