package com.example.vehiclerental;

public class motorcycle extends Vehicle {
    // Fields specific to Motorcycle
    private String type;

    // Constructor
    public motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable, String type) {
        super(vehicleId, model, baseRentalRate); // Pass only three arguments
        this.isAvailable = isAvailable; // Handle isAvailable here
        this.type = type;
    }
    
    // Getter and Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Override abstract methods
    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // Example calculation
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    public void displayAvailability() {
        System.out.println("Motorcycle availability: " + isAvailable);
    }
    
}