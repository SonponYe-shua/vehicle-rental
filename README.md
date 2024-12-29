# Vehicle Rental Management System

## About This Project
This is a simple vehicle rental management system that I developed to demonstrate object-oriented programming principles like encapsulation, inheritance, and polymorphism. 
The system allows users to rent vehicles, check availability, and calculate rental costs based on the number of rental days.
The system also takes prevents already rented vehicles to be accessed.

I built this project as part of my coursework, and it helped me understand how to design and implement a real-world application using Java.

## Features
- Rent vehicles, including cars, motorcycles, and trucks.
- Calculate rental costs automatically.
- Keep track of whether a vehicle is available for rental.
- Prevent renting a vehicle until it is returned.

## How to Run
1. Make sure you have **JDK 11 or higher** installed.
2. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/vehicle-rental
   ```
3. Navigate to the project folder and open it in IntelliJ IDEA or another IDE.
4. Build the project using Maven:
   ```bash
   mvn clean install
   ```
5. Run the application from the `App` class.

## How to Test
I created tests for this project using **JUnit 5**. To run the tests:
1. Ensure you have the required dependencies in your `pom.xml`.
2. Use your IDE’s test runner or run:
   ```bash
   mvn test
   ```
3. All tests should pass successfully if the setup is correct.

## Challenges Faced
One of the biggest challenges was ensuring that vehicles couldn’t be rented when they weren’t returned. 
I implemented checks within the system to handle this.
After these checks, the vehicle is removed from the list of vehicles that could be rented.

## Acknowledgments
In all honesty, the project presented me with challenges I could not face alone hence I consulted Chatgpt for clarification and code error fixes.


