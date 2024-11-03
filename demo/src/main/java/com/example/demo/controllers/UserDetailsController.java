package com.example.demo.controllers;

import com.example.demo.dto.UserDetailsRequestDTO;
import com.example.demo.services.UserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/userDetails")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<Void> createUserDetails(@Valid @RequestBody UserDetailsRequestDTO userDetailsRequestDTO) {
        userDetailsService.createUserDetails(userDetailsRequestDTO);
        return ResponseEntity.ok().build();
    }


}
