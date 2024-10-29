package com.example.demo.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Education {
    @Id
    private Long id;

    private String university;
    private String degree ;
    private String grade ;
    private String major ;
    private LocalDate date;

    @ManyToMany(mappedBy = "educations")
    private List<user_details> user_details = new ArrayList<>();


}
