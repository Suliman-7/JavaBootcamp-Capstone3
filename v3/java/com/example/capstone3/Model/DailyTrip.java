package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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
    @Min(value = 1)
    @Max(value = 3)
    private int period;

    private int price = 0 ;

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

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "dailyTrip")
    private Set<Student> students;




}
