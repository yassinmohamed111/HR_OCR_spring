package com.example.demo.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class user {
    @Id
    private Long id;

    private String email ;
    private String password ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private user_details user_details ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private role role ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobRecords> jobRecords;



}
