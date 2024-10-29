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
public class user_details {

    @Id
    private Long id;
    private String name ;
    private String phone ;
    private String dob;
    private String gender ;
    private String pob ;
    private String military_status ;
    private String SSN ;
    private String address ;
    private String martial_status ;

    //user_details
    @OneToOne(mappedBy = "user_details")
    private user user ;



    @ManyToMany
    @JoinTable(
            name = "user_workExperience",
            joinColumns = @JoinColumn(name = "user_details_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id")
    )
    private List<Experience> experiences = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "user_education",
            joinColumns = @JoinColumn(name = "user_details_id"),
            inverseJoinColumns = @JoinColumn(name = "education_id")
    )
    private List<Education> educations = new ArrayList<>();


}
