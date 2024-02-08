package com.hexaware.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import com.hexaware.dao.ReservationDAO;

import com.hexaware.model.Reservation;

public class ReservationService implements IReservationService{
	Reservation rese;
	Scanner sc = new Scanner(System.in);
	ReservationDAO reservationDAO = new ReservationDAO();
	
	public void createReservation() {
		rese = new Reservation(); 

		System.out.println("--Please enter reservation details--\n");

		System.out.print("Enter Customer ID: ");
		int customerId = sc.nextInt();
		rese.setCustomerID(customerId);

		System.out.print("Enter Vehicle ID: ");
		int vehicleId = sc.nextInt();
		rese.setVehicleID(vehicleId);
		
		System.out.print("Enter Start date and time in yyyy/MM/ddTHH:mm:ss format:");
		String userInput = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US);
		LocalDateTime userDateTime = LocalDateTime.parse(userInput, formatter);
		rese.setStartDate(userDateTime);
		
	    System.out.print("Enter End date and time in yyyy/MM/ddTHH:mm:ss format: ");
	    String userInput1 = sc.next();
		LocalDateTime endDate = LocalDateTime.parse(userInput1, DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US));
		rese.setEndDate(endDate);


		//custList.add(cust);

		System.out.println("reservation details were added succesfully!");
		reservationDAO.createReservation(rese);
	}
	
	@Override
    public void getReservationById() {
		
		    
			System.out.println("enter Reservation id");
			int reservationID =sc.nextInt();
			Reservation reservationById = reservationDAO.getReservationById(reservationID);
	    System.out.println("\n---Reservation Details---\n" + reservationById);
	   
    }
	
	@Override
    public void updateReservation() {
		
		
		System.out.print("Enter Reservation ID to update: ");
        int updateReservationId = sc.nextInt();
        sc.nextLine(); // Consume newline
        Reservation updatedReservation = reservationDAO.getReservationById(updateReservationId);
        if (updatedReservation != null) {
            System.out.print("Enter new Vehicle ID: ");
            updatedReservation.setVehicleID(sc.nextInt());
            System.out.print("Enter new Start Datetime in yyyy/MM/ddTHH:mm:ss format:");
            String userInput = sc.next();
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US);
    		LocalDateTime userDateTime = LocalDateTime.parse(userInput, formatter);
            updatedReservation.setStartDate(userDateTime);
            System.out.print("Enter new End Datetime in yyyy/MM/ddTHH:mm:ss format:");
            String userInput1 = sc.next();
    		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US);
    		LocalDateTime userDateTime1 = LocalDateTime.parse(userInput1, formatter1);
            updatedReservation.setEndDate(userDateTime1);
           
            reservationDAO.updateReservation(updatedReservation);
            System.out.println("Reservation updated successfully");
        } else {
            System.out.println("Reservation not found");
        }
	
	}
	
	@Override
    public void removeReservation() {
	System.out.print("Enter Reservation ID to remove: ");
    int removeReservationId = sc.nextInt();
    reservationDAO.removeReservation(removeReservationId);
    System.out.println("Reservation removed successfully");
	}
	
	@Override
	public void getReservationsByCustomerId() {
		System.out.print("Enter Customer ID : ");
	    int customerId = sc.nextInt();
		List<Reservation> allReservations = reservationDAO.getReservationsByCustomerId(customerId);
		    System.out.println("All Customers Reservation: " + allReservations);
	}
	
	@Override
	public void getReservationsByVehicleId() {
		System.out.print("Enter Vehicle ID : ");
	    int vehicleId = sc.nextInt();
		List<Reservation> allReservations1 = reservationDAO.getReservationsByVehicleId(vehicleId);
		    System.out.println("All Vehicle Reservation: " + allReservations1);
	}
	
	
}
