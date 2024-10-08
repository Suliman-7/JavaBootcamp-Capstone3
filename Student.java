package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotNull(message = "facility id should be not null")
    @Column(columnDefinition = "int not null")
    private int facilityId;

    @NotEmpty(message = "address should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String address;




}
