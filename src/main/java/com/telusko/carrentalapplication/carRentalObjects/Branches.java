package com.telusko.carrentalapplication.carRentalObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Branches")

public class Branches {
    @Id
    private long branchId;
    private String branchName;
    private String location;
    private String phoneNumber;
    private String email;

    public Branches() {
    }

    public Branches(long branchId, String branchName, String location, String phoneNumber, String email) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


}
