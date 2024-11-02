package com.example.demo.controllers;

import com.example.demo.dto.UserDetailsRequestDTO;
import com.example.demo.services.UserDetailsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsController {

    private UserDetailsService userDetailsService;
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public String createUserDetails (@Valid  @RequestBody UserDetailsRequestDTO userDetailsRequestDTO) {
        userDetailsService.createUserDetails(userDetailsRequestDTO);
        return "User Details Created";
    }


}
