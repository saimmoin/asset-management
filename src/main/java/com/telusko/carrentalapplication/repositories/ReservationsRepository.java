package com.telusko.carrentalapplication.repositories;

import com.telusko.carrentalapplication.carRentalObjects.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}
