package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "period should be not null")
    @Column(columnDefinition = "int not null")
    private int period;

    @NotNull(message = "price should be not null")
    @Column(columnDefinition = "double not null")
    private double price;

    @OneToOne
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JsonIgnore
    private Captain captain;



}
