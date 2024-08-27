package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;
    @NotEmpty(message = "Type should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String type;
    @NotEmpty(message = "City should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String city;
    @NotEmpty(message = "Address should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String address;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "facility")
    private Set<Student> students ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "facility")
    private Set<FacilityDeliveryGroup> deliveryGroups;





}