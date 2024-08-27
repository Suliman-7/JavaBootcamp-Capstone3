package com.example.capstone3.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FacilityDeliveryGroupDTO {

    private Integer captainId;

    @Pattern(regexp = "^(north|west|east|south)$")
    @NotEmpty(message = "region should be not empty")
    private String region;

    @NotNull(message = "period should not be null")
    @Min(value = 1)
    @Max(value = 3)
    private int period ;


}
