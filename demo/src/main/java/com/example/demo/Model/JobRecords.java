package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String job_status;
    private LocalDate date ;

    public JobRecords() {
        this.job_status = "Pending";
        this.date = LocalDate.now();
    }
    @JsonBackReference("userJobsReference")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @JsonBackReference("jobsRecordReference")
    @ManyToOne
    @JoinColumn(name = "job_id")
    private jobs job;







}
