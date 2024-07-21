package com.telusko.carrentalapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarsListDto {

    private Long carId;
    private String branchName;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String licensePlate;
    private String status;
    private Double dailyRentalRate;
}
