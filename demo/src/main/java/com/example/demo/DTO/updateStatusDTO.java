package com.example.demo.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class updateStatusDTO {
    private String status;
    private long jobRecordId ;
}
