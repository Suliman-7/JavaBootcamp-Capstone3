package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1,max = 500,message = "Comment should be more than 1 and less than 500 chars!")
    @Column(columnDefinition = "VARCHAR(500) NOT NULL")
    private String comment;

    @NotNull(message = "Rate should not be null")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double rate;
}
