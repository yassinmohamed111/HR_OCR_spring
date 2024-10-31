package com.example.demo.Service;

import com.example.demo.DTO.UserDetailsRequestDTO;
import com.example.demo.DTO.UserResponseDetailsDTO;

import java.util.List;

public interface UserDetailsService {

    public void createUserDetails(UserDetailsRequestDTO userDetailsRequestDTO);
    public List<UserResponseDetailsDTO> retrieveAllUsers();
}
