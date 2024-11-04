package com.example.demo.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    String token;
    UserResponseDetailsDTO userResponseDetailsDTO ;
}
