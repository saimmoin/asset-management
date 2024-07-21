package com.telusko.carrentalapplication.controllers;

import com.telusko.carrentalapplication.carRentalObjects.*;
import com.telusko.carrentalapplication.dto.*;
import com.telusko.carrentalapplication.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

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

    @GetMapping("/cars/getList")
    public List<CarsListDto> getAllCars() {
        List<Cars> cars = carsRepository.findAll();
        List<CarsListDto> carsList = new ArrayList<>();
        for(Cars car : cars){
            CarsListDto carsListDto = new CarsListDto();
            carsListDto.setCarId(car.getCarId());
            carsListDto.setBranchName(car.getBranchInfo().getBranchName());
            carsListDto.setMake(car.getMake());
            carsListDto.setModel(car.getModel());
            carsListDto.setColor(car.getColor());
            carsListDto.setStatus(car.getStatus());
            carsListDto.setYear(car.getYear());
            carsListDto.setLicensePlate(car.getLicensePlate());
            carsListDto.setDailyRentalRate(car.getDailyRentalRate());
            carsList.add(carsListDto);
        }
        return carsList;
    }

    @GetMapping("/maintenance/getList")
    public List<MaintenanceListDto> getAllMaintenance() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();
        List<MaintenanceListDto> maintenanceList = new ArrayList<>();
        for(Maintenance maintenance : maintenances){
            MaintenanceListDto maintenanceListDto = new MaintenanceListDto();
            maintenanceListDto.setMaintenanceId(maintenance.getMaintenanceId());
            maintenanceListDto.setMaintenanceDate(maintenance.getMaintenanceDate());
            maintenanceListDto.setDescription(maintenance.getDescription());
            maintenanceListDto.setCost(maintenance.getCost());
            maintenanceListDto.setStatus(maintenance.getStatus());
            maintenanceListDto.setMake(maintenance.getCarInfo().getMake());
            maintenanceListDto.setModel(maintenance.getCarInfo().getModel());
            maintenanceListDto.setYear(maintenance.getCarInfo().getYear());
            maintenanceList.add(maintenanceListDto);
        }
        return maintenanceList;
    }

    @GetMapping("/reservation/getList")
    public List<ReservationListDto> getAllReservations() {
        List<Reservations> reservations = reservationsRepository.findAll();
        List<ReservationListDto> reservationListDtos = new ArrayList<>();
        for(Reservations reservation : reservations){
            ReservationListDto reservationListDto = new ReservationListDto();
            reservationListDto.setReservationId(reservation.getReservationId());
            reservationListDto.setStartDate(reservation.getStartDate());
            reservationListDto.setEndDate(reservation.getEndDate());
            reservationListDto.setTotalCost(reservation.getTotalCost());
            reservationListDto.setStatus(reservation.getStatus());
            reservationListDto.setCreatedAt(reservation.getCreatedAt());
            reservationListDto.setBranchName(reservation.getBranchInfo().getBranchName());
            reservationListDto.setMake(reservation.getCarInfo().getMake());
            reservationListDto.setModel(reservation.getCarInfo().getModel());
            reservationListDto.setYear(reservation.getCarInfo().getYear());
            reservationListDto.setCnic(reservation.getCustomerInfo().getCnic());
            reservationListDto.setFullName(reservation.getCustomerInfo().getFullName());
            reservationListDtos.add(reservationListDto);
        }
        return reservationListDtos;
    }

    @PostMapping("/branches/add")
    public String addBranch(@RequestBody BranchesAddDTO branchesAddDTO) {
        Branches branches = new Branches();
        branches.setBranchName(branchesAddDTO.getBranchName());
        branches.setEmail(branchesAddDTO.getEmail());
        branches.setLocation(branchesAddDTO.getLocation());
        branches.setPhoneNumber(branchesAddDTO.getPhoneNumber());
        branchRepository.save(branches);
        return "Branch saved successfully!";
    }

    @PostMapping("/customers/add")
    public String addCustomer(@RequestBody CustomersAddDTO customersAddDTO) {
        Customers customers = new Customers();
        customers.setFullName(customersAddDTO.getFullName());
        customers.setEmail(customersAddDTO.getEmail());
        customers.setCnic(customersAddDTO.getCnic());
        customers.setPhoneNumber(customersAddDTO.getPhoneNumber());
        customers.setAddress(customersAddDTO.getAddress());
        customers.setCreatedAt(customersAddDTO.getCreatedAt());
        customerRepository.save(customers);
        return "Customer saved successfully!";
    }

    @PostMapping("/cars/add")
    public String addCars(@RequestBody CarsAddDTO carsAddDTO) {
        Cars cars = new Cars();
        cars.setBranchId(carsAddDTO.getBranchId());
        cars.setMake(carsAddDTO.getMake());
        cars.setModel(carsAddDTO.getModel());
        cars.setYear(carsAddDTO.getYear());
        cars.setColor(carsAddDTO.getColor());
        cars.setLicensePlate(carsAddDTO.getLicensePlate());
        cars.setStatus(carsAddDTO.getStatus());
        cars.setDailyRentalRate(carsAddDTO.getDailyRentalRate());
        carsRepository.save(cars);
        return "Car saved successfully!";
    }

    @PostMapping("/maintenance/add")
    public String addMaintenance(@RequestBody MaintenanceAddDTO maintenanceAddDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setCarId(maintenanceAddDTO.getCarId());
        maintenance.setMaintenanceDate(maintenanceAddDTO.getMaintenanceDate());
        maintenance.setDescription(maintenanceAddDTO.getDescription());
        maintenance.setCost(maintenanceAddDTO.getCost());
        maintenance.setStatus(maintenanceAddDTO.getStatus());
        maintenanceRepository.save(maintenance);
        return "Maintenance saved successfully!";
    }

    @PostMapping("/reservation/add")
    public String addReservation(@RequestBody ReservationAddDTO reservationAddDTO) {
        Reservations reservations = new Reservations();
        reservations.setCustomerId(reservationAddDTO.getCustomerId());
        reservations.setCarId(reservationAddDTO.getCarId());
        reservations.setBranchId(reservationAddDTO.getBranchId());
        reservations.setStartDate(reservationAddDTO.getStartDate());
        reservations.setEndDate(reservationAddDTO.getEndDate());
        reservations.setTotalCost(reservationAddDTO.getTotalCost());
        reservations.setStatus(reservationAddDTO.getStatus());
        reservations.setCreatedAt(reservationAddDTO.getCreatedAt());
        reservationsRepository.save(reservations);
        return "Reservation saved successfully!";
    }

    @GetMapping("/branches/getDropDown")
    public List<BranchDropDownDTO> getAllBranchesForDropDown() {
        List<Branches> branches = branchRepository.findAll();
        List<BranchDropDownDTO> branchDropDownDTOS = new ArrayList<>();
        for(Branches branch : branches) {
            BranchDropDownDTO branchDropDownDTO = new BranchDropDownDTO();
            branchDropDownDTO.setBranchId(branch.getBranchId());
            branchDropDownDTO.setBranchName(branch.getBranchName());
            branchDropDownDTOS.add(branchDropDownDTO);
        }
        return branchDropDownDTOS;
    }

    @GetMapping("/customers/getDropDown")
    public List<CustomerDropDownDTO> getAllCustomersForDropDown() {
        List<Customers> customers = customerRepository.findAll();
        List<CustomerDropDownDTO> customerDropDownDTOS = new ArrayList<>();
        for(Customers customer : customers) {
            CustomerDropDownDTO customerDropDownDTO = new CustomerDropDownDTO();
            customerDropDownDTO.setCustomerId(customer.getCustomerId());
            customerDropDownDTO.setFullName(customer.getFullName());
            customerDropDownDTOS.add(customerDropDownDTO);
        }
        return customerDropDownDTOS;
    }

    @GetMapping("/cars/getDropDown")
    public List<CarDropDownDTO> getAllCarsForDropDown() {
        List<Cars> cars = carsRepository.findAll();
        List<CarDropDownDTO> carDropDownDTOS = new ArrayList<>();
        for(Cars car : cars) {
            CarDropDownDTO carDropDownDTO = new CarDropDownDTO();
            carDropDownDTO.setCarId(car.getCarId());
            carDropDownDTO.setCarName(car.getMake() + " " + car.getModel() + " " + car.getYear());
            carDropDownDTO.setDailyRentalRate(car.getDailyRentalRate());
            carDropDownDTOS.add(carDropDownDTO);
        }
        return carDropDownDTOS;
    }

}
