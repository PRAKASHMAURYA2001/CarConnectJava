package com.hexaware.controller;


import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.VehicleDAO;
import com.hexaware.exception.VehicleNotFoundException;
//import com.hexaware.model.Customer;
import com.hexaware.model.Vehicle;

public class VehicleService implements IVehicleService {
	Vehicle vehi = new Vehicle();
	Scanner sc = new Scanner(System.in);
	VehicleDAO vehicleDAO = new VehicleDAO();

	public void addVehicle() {
	    vehi = new Vehicle(); 

		System.out.println("--Please enter Vehicle details--\n");

		System.out.print("Model Name: ");
		String model = sc.next();
		vehi.setModel(model);

		System.out.print("Name of Maker: ");
		String make = sc.next();
		vehi.setMake(make);
		
		System.out.print("Manifacturing year (YYYY): ");
		int year =sc.nextInt();
		vehi.setYear(year);

		System.out.print("Enter color: ");
		String color = sc.next();
		vehi.setColor(color);

		System.out.print("Registration Number: ");
		String registrationNumber = sc.next();
		vehi.setRegistrationNumber(registrationNumber);

		System.out.print("Availability: ");
		boolean availability = sc.nextBoolean();
		vehi.setAvailability(availability);
		
		System.out.print("Daily rate: ");
		int dailyRate = sc.nextInt();
		vehi.setDailyRate(dailyRate);
		
		System.out.println("Vehicle details were added succesfully!");
		vehicleDAO.addVehicle(vehi);
	}
	
	@Override
    public void getVehicleById() throws VehicleNotFoundException {
		System.out.println("enter Vehicle id");
		int vehicleId =sc.nextInt();
		try {
		Vehicle vehicleById = vehicleDAO.getVehicleById(vehicleId);
	    if (vehicleById != null) {
            // Display vehicle details
	    	System.out.println("\n---Vehicle Details---\n" + vehicleById);
        } else {
            System.out.println("Vehicle not found.");
        }
    } catch (VehicleNotFoundException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
	
	@Override
    public void getAvailableVehicles() {
		
		List<Vehicle> allVehicles = vehicleDAO.getAvailableVehicles();
	    System.out.println("All Employees: " + allVehicles);
	   
	   
    }
	
	@Override
    public void updateVehicle() throws VehicleNotFoundException {
		
		 try {	
		System.out.print("Enter Vehicle ID to update: ");
        int updateVehicleId = sc.nextInt();
        sc.nextLine(); // Consume newline
        Vehicle updatedVehicle = vehicleDAO.getVehicleById(updateVehicleId);
        if (updatedVehicle != null) {
            System.out.print("Enter new Color: ");
            updatedVehicle.setColor(sc.nextLine());
            System.out.print("Enter Availability : ");
            updatedVehicle.setAvailability(sc.nextBoolean());
            System.out.print("Enter new Daily Rate: ");
            updatedVehicle.setDailyRate(sc.nextInt());
            
           
            vehicleDAO.updateVehicle(updatedVehicle);
            System.out.println("Vehicle updated successfully");
        } else {
            System.out.println("Vehicle not found");
        }
		 }catch (VehicleNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            // Handle or log the exception as needed
        }
	
	}
	
	@Override
    public void removeVehicle() {
	System.out.print("Enter Customer ID to remove: ");
    int removeVehicleId = sc.nextInt();
    vehicleDAO.removeVehicle(removeVehicleId);
    System.out.println("Vehicle removed successfully");
	}
}
