package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String university;
    private String degree ;
    private String grade ;
    private String major ;
    private LocalDate date;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    @JsonBackReference("userDetailsEduReference")
    private user_details user_details;


}
