package com.example.vehiclerental;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (loadCapacity * 2); // Additional cost based on load capacity
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
