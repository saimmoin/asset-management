package com.telusko.carrentalapplication.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaintenanceAddDTO {
    private long carId;
    private Date maintenanceDate;
    private String description;
    private Double cost;
    private String status;
}
