package com.telusko.carrentalapplication.dto;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationAddDTO {
    private long customerId;
    private long carId;
    private long branchId;
    private Date startDate;
    private Date endDate;
    private Double totalCost;
    private String status;
    private Date createdAt;
}
