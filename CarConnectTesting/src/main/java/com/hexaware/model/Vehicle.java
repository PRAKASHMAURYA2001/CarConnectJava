package com.hexaware.model;

public class Vehicle {
    private int vehicleID;
    private String model;
    private String make;
    private int year;
    private String color;
    private String registrationNumber;
    private boolean availability;
    private double dailyRate;

    // Default constructor
    public Vehicle() {
    }

    // Parametrized constructor
    public Vehicle(int vehicleID, String model, String make, int year, String color,
                   String registrationNumber, boolean availability, double dailyRate) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.availability = availability;
        this.dailyRate = dailyRate;
    }

    // Getters and setters for all properties

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }
    public String toString() {
        return  "Vehicle [\nvehicleID=" + vehicleID +
                ", \nmodel=" + model +
                ", \nmake=" + make +
                ", \nyear=" + year +
                ", \ncolor=" + color +
                ", \nregistrationNumber=" + registrationNumber +
                ", \navailability=" + availability +
                ", \ndailyRate=" + dailyRate +
                "]\n";
    
    }
}
