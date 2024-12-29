package com.example.vehiclerental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerId;
    private List<Vehicle> rentalHistory;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Vehicle> getRentalHistory() {
        return rentalHistory;
    }

    public void rentVehicle(Vehicle vehicle) {
        vehicle.setAvailable(false);
        rentalHistory.add(vehicle);
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
    }
}
