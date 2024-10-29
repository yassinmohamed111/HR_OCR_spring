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

    @OneToMany(mappedBy = "user_details"  , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "user_details"  , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})
    private List<Experience> experiences = new ArrayList<>();




}
