package com.example.capstone3.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class RequestRideDTO {

    private Integer studentId;

    @NotEmpty(message = "Start point should not be empty!")
    private String startPoint;


    @NotNull(message = "leave Hour should not be empty!")
    @JsonFormat(pattern = "hh:mm")
    private Time leaveHour;


    @NotEmpty(message = "Destination should not be empty!")
    private String destination;

    @NotNull(message = "period should be not Null")
    @Min(value = 1)
    @Max(value = 3)
    private int period;

    private int price =  0 ;




}
