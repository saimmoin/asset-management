package com.telusko.carrentalapplication.repositories;

import com.telusko.carrentalapplication.carRentalObjects.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
