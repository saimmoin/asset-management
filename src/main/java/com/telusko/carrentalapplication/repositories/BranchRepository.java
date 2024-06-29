package com.telusko.carrentalapplication.repositories;

import com.telusko.carrentalapplication.carRentalObjects.Branches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branches, Long> {
}
