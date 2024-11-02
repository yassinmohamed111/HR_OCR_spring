package com.example.demo.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {
    private String postion;
    private String reason;
    private String company_name;
    private LocalDate start_date;
    private LocalDate end_date;
}
