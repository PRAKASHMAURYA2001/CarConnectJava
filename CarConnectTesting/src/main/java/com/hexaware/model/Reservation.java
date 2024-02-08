package com.hexaware.model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Reservation {
    private int reservationID;
    private int customerID;
    private int vehicleID;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double totalCost;
    private String status;

    // Default constructor
    public Reservation() {
    }

    // Parametrized constructor
    public Reservation(int reservationID, int customerID, int vehicleID, LocalDateTime startDate,
    		LocalDateTime endDate, double totalCost, String status) {
        this.reservationID = reservationID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    // Getters and setters for all properties

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "Reservation{" +
        "\n  reservationID=" + reservationID +
        "\n  customerID=" + customerID +
        "\n  vehicleID=" + vehicleID +
        "\n  startDate=" + startDate.format(formatter) +
        "\n  endDate=" + endDate.format(formatter) +
        "\n  totalCost=" + totalCost +
        "\n  status='" + status + '\'' +
        "\n}";
    }
   
}
