package com.example.vehiclerental;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private final List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public Vehicle getVehicleById(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public void rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (vehicle.isAvailableForRental()) {
            double rentalCost = vehicle.calculateRentalCost(days);
            customer.rentVehicle(vehicle);
            System.out.println("Rented " + vehicle.getModel() + " to " + customer.getName() +
                    " for " + days + " days. Total cost: GHC" + rentalCost);
        } else {
            System.out.println(vehicle.getModel() + " is not available for rental.");
        }
    }

    public void removeVehicle(String vehicleId) {
        fleet.removeIf(vehicle -> vehicle.getVehicleId().equals(vehicleId));
    }
}

