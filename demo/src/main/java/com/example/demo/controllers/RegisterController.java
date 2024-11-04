package com.example.demo.controllers;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;
import com.example.demo.jwt.JwtService;
import com.example.demo.models.Users;
import com.example.demo.services.UserDetailsService;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")

public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;



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

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDTO userRequestDTO) {

        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(userRequestDTO.getEmail(),userRequestDTO.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userRequestDTO.getEmail()) ;
        }else {
            return "failure";
        }
    }

}
