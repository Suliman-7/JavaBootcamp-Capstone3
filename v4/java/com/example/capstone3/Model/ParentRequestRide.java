package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ParentRequestRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //private int numOFchildren;

    //private int parentId;

    @Column(columnDefinition = "varchar(30) not null")
    private String parentName;

    @Column(columnDefinition = "varchar(50) not null")
    private String startPoint;

    @Column(columnDefinition = "time not null")
    private Time leaveHour;


    @Column(columnDefinition = "int not null")
    private int period;

    @Column(columnDefinition = "double")
    private double price =0;

    @OneToOne
    @JsonIgnore
    private Parent parent;

    @OneToOne
    @JsonIgnore
    private Captain captain;

}
