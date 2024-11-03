package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStatusDTO {
    private String status;
    private long jobRecordId ;
}