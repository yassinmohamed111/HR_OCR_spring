package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    private Long id;
    private String postion;
    private String reason ;
    private String company_name ;
    private LocalDate start_date ;
    private LocalDate end_date ;


    @ManyToMany(mappedBy = "experiences")
    private List<user_details> user_details = new ArrayList<>();


}
