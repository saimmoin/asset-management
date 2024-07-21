package com.telusko.carrentalapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDropDownDTO {

    private String carName;
    private long carId;
    private Double dailyRentalRate;
}
