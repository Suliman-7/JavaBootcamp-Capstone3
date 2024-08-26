package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DailyTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "price should be not null")
    @Positive
    @Column(columnDefinition = "double not null")
    private double price;

    @NotEmpty(message = "start point should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String startPoint;

    @NotEmpty(message = "destination should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String destination;

    @NotNull(message = "leave hour should be not null")
    @Column(columnDefinition = "int not null")
    private int leaveHour;

    @ManyToOne
    @JsonIgnore
    private Captain captain;
}
