package com.telusko.carrentalapplication.carRentalObjects;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Reservations")

public class Reservations {

    @Id
    private long reservationId;

    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "car_id")
    private long carId;
    @Column(name = "branch_id")
    private long branchId;
    private Date startDate;
    private Date endDate;
    private Double totalCost;
    private String status;
    private Date createdAt;

    public Reservations(long reservationId, long customerId, long carId, long branchId, Date startDate, Date endDate, Double totalCost, String status, Date createdAt) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.carId = carId;
        this.branchId = branchId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Reservations() {
    }

    @ManyToOne
    @JoinColumn(name="customer_id", insertable = false, updatable = false)
    private Customers customerInfo;

    @ManyToOne
    @JoinColumn(name="car_id", insertable = false, updatable = false)
    private Cars carInfo;

    @ManyToOne
    @JoinColumn(name="branch_id", insertable = false, updatable = false)
    private Branches branchInfo;

}
