package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{Parent} name should not be empty!")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "last name must contain only characters")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty(message = "parent phone number should not be empty!")
    @Size(min = 10,max = 10,message = "parent phone number should be '10' digits")
    @Pattern(regexp = "^05\\d*$",message = "Phone number must start with '05' !")
    @Column(columnDefinition = "varchar(10) not null")
    private String phoneNumber;

    @NotEmpty(message = "Parent email should not be empty")
    @Email(message = "Parent email should be formatted successfully")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "parent")
    private Set<SuccessorStudent> successorStudents;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "parent")
    private ParentRequestRide parentRequestRide;
}
