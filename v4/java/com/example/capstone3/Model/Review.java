package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Comment should not be empty")
    @Column(columnDefinition = "VARCHAR(500) NOT NULL")
    private String comment;

    @NotNull(message = "Rate should not be null")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double rate;

    private String studentName = "" ;


    @ManyToOne
    @JsonIgnore
    private Captain captain;

    @ManyToOne
    @JsonIgnore
    private Student student;


}