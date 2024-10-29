package com.example.demo.Mapper;

import com.example.demo.DTO.UserRequestDTO;
import com.example.demo.Model.Users;
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
