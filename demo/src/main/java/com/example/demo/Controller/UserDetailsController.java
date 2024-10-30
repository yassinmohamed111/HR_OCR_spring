package com.example.demo.Controller;

import com.example.demo.DTO.UserDetailsRequestDTO;
import com.example.demo.Service.UserDetailsService;
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
