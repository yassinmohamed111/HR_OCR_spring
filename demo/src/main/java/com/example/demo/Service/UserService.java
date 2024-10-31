package com.example.demo.Service;


import com.example.demo.DTO.UserRequestDTO;
import com.example.demo.Model.Users;

import java.util.List;


public interface UserService {

    public void createUser(UserRequestDTO userRequestDTO);
    public void createAdmin(UserRequestDTO userRequestDTO);

}
