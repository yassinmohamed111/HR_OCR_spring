package com.example.demo.controllers;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;
import com.example.demo.services.UserDetailsService;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsService userDetailsService;



    @PostMapping("/admin")
    public String createAdmin(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.createAdmin(userRequestDTO);
        return "admin created successfully";
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping
    public List<UserResponseDetailsDTO> retriveAllusers()
    {
        return userDetailsService.retrieveAllUsers();
    }

}
