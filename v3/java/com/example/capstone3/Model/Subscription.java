//package com.example.capstone3.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class Subscription {
//
//    @Id
//    private Integer id;
//
//
//    @Column(columnDefinition = "int not null")
//    private int period;
//
//    @Column(columnDefinition = "double not null")
//    private double price;
//
//    @OneToOne
//    @MapsId
//    @JsonIgnore
//    private Student student;
//
//    @ManyToOne
//    @JsonIgnore
//    private Captain captain;
//
//
//
//}
