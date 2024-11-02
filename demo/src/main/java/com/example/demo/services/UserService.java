package com.example.demo.services;


import com.example.demo.dto.UserRequestDTO;


public interface UserService {

    public void createUser(UserRequestDTO userRequestDTO);
    public void createAdmin(UserRequestDTO userRequestDTO);

}
