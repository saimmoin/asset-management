package com.telusko.carrentalapplication.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MaintenanceListDto {

    private long maintenanceId;
    private Date maintenanceDate;
    private String description;
    private Double cost;
    private String status;
    private String make;
    private String model;
    private Integer year;

}
