package com.example.demo.Controller;

import com.example.demo.DTO.UserRequestDTO;
import com.example.demo.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    UserService userService;
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin")
    public String createAdmin(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createAdmin(userRequestDTO);
        return "admin created successfully";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        return "user created successfully";
    }

}
