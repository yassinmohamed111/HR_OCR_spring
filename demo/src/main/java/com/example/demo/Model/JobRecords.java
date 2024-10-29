package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class JobRecords {


    @Id
    private Long id;
    private String job_status;
    private LocalDate date ;

    public JobRecords() {

        this.date = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private jobs job;







}
