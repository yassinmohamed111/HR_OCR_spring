package com.example.demo.Service;


import com.example.demo.DTO.UserRequestDTO;


public interface UserService {

    public void createUser(UserRequestDTO userRequestDTO);
    public void createAdmin(UserRequestDTO userRequestDTO);
}
