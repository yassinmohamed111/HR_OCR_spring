package com.example.demo.services;

import com.example.demo.dto.UserDetailsRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;

import java.util.List;

public interface UserDetailsService {

    public void createUserDetails(UserDetailsRequestDTO userDetailsRequestDTO);
    public List<UserResponseDetailsDTO> retrieveAllUsers();
}
