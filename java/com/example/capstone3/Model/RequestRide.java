package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RequestRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Start point should not be empty!")
    @Column(columnDefinition = "varchar(30) not null")
    private String startPoint;


    @NotNull(message = "leave Hour should not be empty!")
    @JsonFormat(pattern = "hh:mm")
    @Column(columnDefinition = "time not null")
    private Time leaveHour;


    @NotEmpty(message = "Destination should not be empty!")
    @Column(columnDefinition = "varchar(30) not null")
    private String destination;

    @Column(columnDefinition = "datetime")
    private LocalDateTime requestInitialize = LocalDateTime.now();

    @OneToOne
    @JsonIgnore
    private Student student;

    @OneToOne
    @JsonIgnore
    private Captain captain;
}