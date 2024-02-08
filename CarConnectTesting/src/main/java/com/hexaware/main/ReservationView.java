package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.IReservationService;
import com.hexaware.controller.ReservationService;

/**
 * The ReservationView class provides a menu-driven interface for reservation-related operations.
 */
public class ReservationView {
	
	IReservationService reservationService = new ReservationService();
	Scanner sc = new Scanner(System.in);
	
	/**
     * Displays the reservation menu and handles user inputs.
     */
    public void displayMenu() {
	
 	   String ch = null;
 	   
 	   do {
 		  System.out.println(" Registration menu ");
 		   System.out.println("Enter your choice");
			System.out.println("1. Register");
			System.out.println("2. View Reservation Details By Reservation ID");
			System.out.println("3. View Reservation Details By Customer ID");
			System.out.println("4. View Reservation Details By Vehicle ID");
			System.out.println("5. Cancel Reservation");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				reservationService.createReservation();
				    break;
				
			case 2:
				reservationService.getReservationById();
				    break;
				
			case 3:
				reservationService.getReservationsByCustomerId();
				    break;
				    
			case 4:
				reservationService.getReservationsByVehicleId();
				  break;  
			case 5:
				reservationService.removeReservation();
				    break;
			
				    
			default:
				    System.out.println("Choose a proper choice");
				    break;
			}
			System.out.println("Do you want to continue? Y | y");
			ch = sc.next();
 	   } while (ch.equals("Y") || ch.equals("y"));
	
   }
		

}
