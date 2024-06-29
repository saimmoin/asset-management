package com.telusko.carrentalapplication.carRentalObjects;

import jakarta.persistence.*;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Customers")

public class Customers {
    @Id
    private long customerId;
    private String cnic;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private Date createdAt;

    public Customers() {
    }

    public Customers(long customerId, String cnic, String fullName, String email, String phoneNumber, String address, Date createdAt) {
        this.customerId = customerId;
        this.cnic = cnic;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = createdAt;
    }

}
