package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class SuccessorStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not null")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @Pattern(regexp = "^(M|F)$")
    @NotEmpty(message = "gender should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String gender;

    @NotNull(message = "age should be not null")
    @Column(columnDefinition = "int not null")
    @Max(value = 18,message = "Successor student max age is 18")
    @Min(value = 6,message = "Successor student minimum age is 6")
    private int age;

    @NotEmpty(message = "academic level should be not null")
    @Pattern(regexp = "^(KG|Biggener|Intermediate|High school)$")
    @Column(columnDefinition = "varchar(30) not null")
    private String academicLevel;

    @Column(columnDefinition = "boolean")
    private boolean disable;

    @NotNull(message = "School id should not be empty!")
    @Positive(message = "school id should be positive number!")
    @Column(columnDefinition = "int not null")
    private int SchoolId;

    @ManyToOne
    @JsonIgnore
    private Parent parent;

    @ManyToOne
    @JsonIgnore
    private Facility facility;

    @ManyToOne
    @JsonIgnore
    private DailyTrip dailyTrip;
}
