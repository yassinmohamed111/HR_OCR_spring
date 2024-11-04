package com.example.demo.controllers;

import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDetailsDTO;
import com.example.demo.jwt.JwtService;
import com.example.demo.models.Users;
import com.example.demo.services.UserDetailsService;
import com.example.demo.services.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
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
        try {
            userService.createUser(userRequestDTO);
            return ResponseEntity.ok("User created successfully");
        } catch (DataIntegrityViolationException e) {
            // Check if the exception is due to a duplicate entry
            if (e.getRootCause() instanceof SQLIntegrityConstraintViolationException) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists.");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the user.");
        }
    }

    @GetMapping
    public List<UserResponseDetailsDTO> retriveAllusers()
    {
        return userDetailsService.retrieveAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequestDTO.getEmail(), userRequestDTO.getPassword())
        );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(userRequestDTO.getEmail());

            // Assuming you have a method to fetch user details by email
            UserResponseDetailsDTO userResponseDetailsDTO = userService.getUser(userRequestDTO.getEmail());

            // Create the response object with user details
            LoginResponseDTO response = new LoginResponseDTO(token, userResponseDetailsDTO); // Adjust as necessary
            return ResponseEntity.ok(response); // Return as JSON
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("failure");
        }
    }



}
