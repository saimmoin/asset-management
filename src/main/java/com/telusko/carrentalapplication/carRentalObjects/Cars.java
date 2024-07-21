package com.telusko.carrentalapplication.carRentalObjects;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Cars")

public class Cars {
    @Id
    private long carId;

    @Column(name = "branch_id")
    private long branchId;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String licensePlate;
    private String status;
    private Double dailyRentalRate;
    @ManyToOne
    @JoinColumn(name="branch_id", insertable = false, updatable = false)
    private Branches branchInfo;

    public Cars(long carId, long branchId, String make, String model, Integer year, String color, String licensePlate, String status, Double dailyRentalRate) {
        this.carId = carId;
        this.branchId = branchId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.licensePlate = licensePlate;
        this.status = status;
        this.dailyRentalRate = dailyRentalRate;
    }

    public Cars() {
    }


}
