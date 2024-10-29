package com.example.demo.DTO;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private String university;
    private String degree ;
    private String grade ;
    private String major ;
    private LocalDate date;
}
