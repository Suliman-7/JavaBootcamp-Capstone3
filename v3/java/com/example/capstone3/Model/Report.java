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
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Report title should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @Column(columnDefinition = "varchar(50)")
    private String description;


    @Column(columnDefinition = "int")
    private int capId;

    @Column(columnDefinition = "varchar(30)")
    private String captainName;

    @ManyToOne
    @JsonIgnore
    private Student student;
}
