package com.hexaware.controller;

import com.hexaware.exception.VehicleNotFoundException;

public interface IVehicleService {

	void getVehicleById() throws VehicleNotFoundException;

    // Method to retrieve available vehicles
    void getAvailableVehicles();

    // Method to add a new vehicle
    void addVehicle();

    // Method to update vehicle information
    void updateVehicle() throws VehicleNotFoundException;

    // Method to remove a vehicle by ID
    void removeVehicle();
}
