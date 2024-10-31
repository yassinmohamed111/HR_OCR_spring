package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDetailsDTO {
    long id;
    private String name;
    private String email;
    private String phone;
    private String dob;
    private String gender;
    private String pob;
    private String military_status;
    private String SSN;
    private String address;
    private String martial_status;
    private String role ;

}