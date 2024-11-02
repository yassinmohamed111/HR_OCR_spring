package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobrecordResponseDTO {
    long userid ;
    long jobId ;
    long jobrecordId ;
    String jobStatus ;
    LocalDate applyDate ;
}
