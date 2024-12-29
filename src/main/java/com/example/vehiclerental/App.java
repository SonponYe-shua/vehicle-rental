package com.example.vehiclerental;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("ID:22082706");
        System.out.println("ID:22082706");
        System.out.println("ID:22082706");

        RentalAgency agency = new RentalAgency();

        // Sample vehicles to add to the fleet
        agency.addVehicle(new Car("CAR001", "Toyota Camry", 50, true));
        agency.addVehicle(new motorcycle("BIKE001", "Yamaha MT-07", 30, true, "Cruiser"));
        agency.addVehicle(new Truck("TRUCK001", "Ford F-150", 80, 1000));
        agency.addVehicle(new Car("KAT001","Kantanka Express",87,true));
        agency.addVehicle(new motorcycle("BIKE002","X-force 20", 43,true,"freestyle"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("\nVehicle Rental System Menu:");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. Remove a Vehicle");
            System.out.println("4. Display Available Vehicles");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    rentVehicle(agency, scanner);
                    break;
                case 2:
                    returnVehicle(agency, scanner);
                    break;
                case 3:
                    removeVehicle(agency, scanner);
                    break;
                case 4:
                    displayAvailableVehicles(agency);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void rentVehicle(RentalAgency agency, Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = new Customer(name, customerId);

        List<Vehicle> availableVehicles = agency.getAvailableVehicles();
        if (availableVehicles.isEmpty()) {
            System.out.println("No vehicles available for rental.");
            return;
        }

        System.out.println("Available Vehicles:");
        for (int i = 0; i < availableVehicles.size(); i++) {
            Vehicle vehicle = availableVehicles.get(i);
            System.out.println((i + 1) + ". " + vehicle.getModel() + " (ID: " + vehicle.getVehicleId() + ")");
        }

        System.out.print("Choose a vehicle by entering its number: ");
        int vehicleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (vehicleChoice < 1 || vehicleChoice > availableVehicles.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Vehicle chosenVehicle = availableVehicles.get(vehicleChoice - 1);

        System.out.print("Enter the number of days for rental: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        agency.rentVehicle(customer, chosenVehicle, days);
    }

    private static void returnVehicle(RentalAgency agency, Scanner scanner) {
        System.out.print("Enter the Vehicle ID to return: ");
        String vehicleId = scanner.nextLine();

        Vehicle vehicle = agency.getVehicleById(vehicleId);
        if (vehicle != null && !vehicle.isAvailable()) {
            vehicle.setAvailable(true);
            System.out.println("Vehicle with ID " + vehicleId + " has been successfully returned.");
        } else if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " does not exist.");
        } else {
            System.out.println("Vehicle with ID " + vehicleId + " was not rented.");
        }
    }

    private static void removeVehicle(RentalAgency agency, Scanner scanner) {
        System.out.print("Enter the Vehicle ID to remove: ");
        String vehicleId = scanner.nextLine();

        agency.removeVehicle(vehicleId);
    }

    private static void displayAvailableVehicles(RentalAgency agency) {
        List<Vehicle> availableVehicles = agency.getAvailableVehicles();
        if (availableVehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle.getModel() + " (ID: " + vehicle.getVehicleId() + ")");
        }
    }
}
