package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.Set;
import java.util.concurrent.Flow;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Pattern(regexp = "^(M|F)$")
    @NotEmpty(message = "gender should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String gender;

    @NotNull(message = "age should be not null")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "academic level should be not null")
    @Pattern(regexp = "^(KG|Biggener|Intermediate|High school|Diploma)$")
    @Column(columnDefinition = "varchar(20) not null")
    private String academicLevel;

    @Column(columnDefinition = "boolean")
    private boolean disable;

    @NotEmpty(message = "address should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String address;

    @NotEmpty(message = "teacher phone number should not be empty!")
    @Size(min = 10,max = 10,message = "teacher phone number should be '10' digits")
    @Pattern(regexp = "^05\\d*$",message = "Phone number must start with '05' !")
    private String phoneNumber;

    @ManyToOne
    @JsonIgnore
    private Captain captain;

    @ManyToOne
    @JsonIgnore
    private Facility facility;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "student")
    private Set<Review> reviews;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "student")
    private Subscription subscription;

    @ManyToOne
    @JsonIgnore
    private DailyTrip dailyTrip;

    @ManyToOne
    @JsonIgnore
    private FacilityDeliveryGroup deliveryGroup;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private RequestRide requestRide;






}
