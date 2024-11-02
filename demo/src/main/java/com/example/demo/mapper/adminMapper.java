package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.models.Users;
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
