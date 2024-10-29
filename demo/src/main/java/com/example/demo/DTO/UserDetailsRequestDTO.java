package com.example.demo.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsRequestDTO {
    private String name ;
    private String email ;
    private String phone ;
    private String dob;
    private String gender ;
    private String pob ;
    private String military_status ;
    private String SSN ;
    private String address ;
    private String martial_status ;

}
