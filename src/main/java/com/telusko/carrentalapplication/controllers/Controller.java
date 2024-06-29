package com.telusko.carrentalapplication.controllers;

import com.telusko.carrentalapplication.carRentalObjects.Branches;
import com.telusko.carrentalapplication.carRentalObjects.Customers;
import com.telusko.carrentalapplication.repositories.BranchRepository;
import com.telusko.carrentalapplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/customers/getList")
    public List<Customers> getAllCustomers() {
        List<Customers> customers = customerRepository.findAll();
        return customers;
    }

    @GetMapping("/branches/getList")
    public List<Branches> getAllBranches() {
        List<Branches> branches = branchRepository.findAll();
        return branches;
    }

}
