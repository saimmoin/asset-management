package com.telusko.carrentalapplication.carRentalObjects;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Car_Maintenance")

public class Maintenance {
    @Id
    private long maintenanceId;

    @Column(name = "car_id")
    private long carId;
    private Date maintenanceDate;
    private String description;
    private Double cost;
    private String status;
    @ManyToOne
    @JoinColumn(name="car_id", insertable = false, updatable = false)
    private Cars carInfo;

    public Maintenance(long maintenanceId, long carId, Date maintenanceDate, String description, Double cost, String status) {
        this.maintenanceId = maintenanceId;
        this.carId = carId;
        this.maintenanceDate = maintenanceDate;
        this.description = description;
        this.cost = cost;
        this.status = status;
    }

    public Maintenance() {
    }
}
