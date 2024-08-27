package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class FacilityDeliveryGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JsonIgnore
    private Facility facility;

    @OneToOne
    @JsonIgnore
    private Captain captain;

    private int period ;

    private int joinedStudents = 0  ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "deliveryGroup")
    private Set<Student> students;


}
