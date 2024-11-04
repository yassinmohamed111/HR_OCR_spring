package com.example.demo.services;


import com.example.demo.dto.UserDetailsRequestDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;


public interface UserService {

    public void createUser(UserRequestDTO userRequestDTO);
    public void createAdmin(UserRequestDTO userRequestDTO);
    public UserResponseDetailsDTO getUser(String email );

}
