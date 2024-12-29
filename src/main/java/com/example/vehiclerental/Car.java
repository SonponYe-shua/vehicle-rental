
package com.example.vehiclerental;

public class Car extends Vehicle {
    private boolean hasAirConditioning;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioning) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasAirConditioning) {
            cost += 10 * days; // Additional cost for air conditioning
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
