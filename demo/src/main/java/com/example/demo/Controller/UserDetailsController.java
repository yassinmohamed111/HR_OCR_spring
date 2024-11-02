package com.example.demo.Controller;

import com.example.demo.DTO.UserDetailsRequestDTO;
import com.example.demo.Service.UserDetailsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/userDetails")
public class UserDetailsController {

    private UserDetailsService userDetailsService;
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<Void> createUserDetails(@Valid @RequestBody UserDetailsRequestDTO userDetailsRequestDTO) {
        userDetailsService.createUserDetails(userDetailsRequestDTO);
        return ResponseEntity.ok().build();
    }


}
