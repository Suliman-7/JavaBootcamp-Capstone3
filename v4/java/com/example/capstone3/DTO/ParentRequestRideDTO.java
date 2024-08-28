package com.example.capstone3.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;

@Data
@AllArgsConstructor

public class ParentRequestRideDTO {

    private Integer parentId;

    private String parentName;

    @NotEmpty(message = "Start point should not be empty!")
    private String startPoint;


    @NotNull(message = "leave Hour should not be empty!")
    @JsonFormat(pattern = "hh:mm")
    private Time leaveHour;

    @NotNull(message = "period should be not Null")
    @Min(value = 1)
    @Max(value = 3)
    private int period;

    private double price =0;
}
