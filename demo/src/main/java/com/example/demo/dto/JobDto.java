package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    @NotNull
    private Long id;
    @NotNull
    @NotBlank
    private String title;
    private String description;
    private String requirements;
    private String recruiter;
}
