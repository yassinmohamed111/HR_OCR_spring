package com.example.demo.Mapper;

import com.example.demo.DTO.UserRequestDTO;
import com.example.demo.Model.Users;
import org.springframework.stereotype.Component;

@Component
public class adminMapper {
    public Users mapperTOentity(UserRequestDTO userRequestDTO) {
        Users Users = new Users();
        Users.setPassword(userRequestDTO.getPassword());
        Users.setEmail(userRequestDTO.getEmail());
        Users.setRole("admin");

        return Users;
    }
}
