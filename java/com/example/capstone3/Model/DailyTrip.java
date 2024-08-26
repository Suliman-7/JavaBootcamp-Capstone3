package com.example.capstone3.Model;

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

    @NotNull(message = "captain id should be not null")
    @Column(columnDefinition = "INT NOT NULL")
    private int captainId;

    @NotNull(message = "price should be not null")
    @Positive
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double price;

    @NotEmpty(message = "start point should be not null")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String startPoint;

    @NotEmpty(message = "destination should be not null")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String destination;

    @NotNull(message = "leave hour should be not null")
    @Column(columnDefinition = "INT NOT NULL")
    private int leaveHour;
}
