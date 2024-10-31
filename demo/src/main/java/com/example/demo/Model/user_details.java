package com.example.demo.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    private String name ;

    @NotBlank(message = "Phone cannot be blank")
    private String phone ;

    @NotBlank(message = "dob cannot be blank")
    private String dob;

    @NotBlank(message = "Gender cannot be blank")
    private String gender ;
    @NotBlank(message = "pob cannot be blank")
    private String pob ;
    @NotBlank(message = "military status cannot be blank")
    private String military_status ;
    @Column(unique = true)
    @NotBlank(message = "SSN cannot be blank")
    private String SSN ;
    @NotBlank(message = "address cannot be blank")
    private String address ;
    @NotBlank(message = "marital status cannot be blank")
    private String martial_status ;

    //user_details
    @JsonBackReference("userDetailsReference")
    @OneToOne(mappedBy = "user_details")
    private Users Users;

    @OneToMany(mappedBy = "user_details"  , cascade = {CascadeType.DETACH , CascadeType.MERGE ,
            CascadeType.PERSIST , CascadeType.REFRESH})
    @JsonManagedReference("userDetailsEduReference")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "user_details"  , cascade = {CascadeType.DETACH , CascadeType.MERGE ,
            CascadeType.PERSIST , CascadeType.REFRESH})
    @JsonManagedReference("userDetailsExpReference")
    private List<Experience> experiences = new ArrayList<>();




}
