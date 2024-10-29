package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postion;
    private String reason;
    private String company_name;
    private LocalDate start_date;
    @Column(nullable = true)
    private LocalDate end_date = null;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private user_details user_details;


}