package com.telusko.carrentalapplication.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationListDto {

    private long reservationId;
    private Date startDate;
    private Date endDate;
    private Double totalCost;
    private String status;
    private Date createdAt;
    private String branchName;
    private String make;
    private String model;
    private Integer year;
    private String cnic;
    private String fullName;


}
