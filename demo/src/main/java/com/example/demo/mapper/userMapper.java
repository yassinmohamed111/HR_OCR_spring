package com.example.demo.mapper;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.models.Users;
import org.springframework.stereotype.Component;

@Component
public class userMapper {

    public Users mapperToEntity(UserRequestDTO userRequestDTO) {
        Users Users = new Users();
        Users.setEmail(userRequestDTO.getEmail());
        Users.setPassword(userRequestDTO.getPassword());
        Users.setRole("user");
        return Users;


    }



}
