package com.example.capstone3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private int captainId;

    @NotNull(message = "price should be not null")
    @Positive
    private double price;

    @NotEmpty(message = "start point should be not null")
    private String startPoint;

    @NotEmpty(message = "destination should be not null")
    private String destination;

    @NotNull(message = "leave hour should be not null")
    private int leaveHour;
}
