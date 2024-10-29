package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

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


    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private user_details user_details;


}
