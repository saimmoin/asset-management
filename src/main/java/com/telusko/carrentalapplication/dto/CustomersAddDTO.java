package com.telusko.carrentalapplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomersAddDTO {

    private String cnic;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private Date createdAt;
}
