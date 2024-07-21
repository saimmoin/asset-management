package com.telusko.carrentalapplication.repositories;

import com.telusko.carrentalapplication.carRentalObjects.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {
}
