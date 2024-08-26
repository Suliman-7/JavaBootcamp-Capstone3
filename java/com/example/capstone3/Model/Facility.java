package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 25,message = "Name should be more than 2 and less than 25 chars!")
    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String name;
    @NotEmpty(message = "Type should not be empty")
    @Size(min = 2, max = 25,message = "Type should be more than 2 and less than 20 chars!")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String type;
    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 25,message = "City should be more than 2 and less than 20 chars!")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String city;
    @NotEmpty(message = "Address should not be empty")
    @Size(min = 2, max = 20,message = "Address should be more than 2 and less than 20 chars!")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String address;
}
