package com.hexaware.main;


import java.util.Scanner;

import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.exception.VehicleNotFoundException;

/*
   Note 
   for calculating the total cost in reservation and status i have used trigers
   and simultaneously vehicle availability is updated if reservation is done using trigers
 */
/**
 * The main class for the Car Connect application.
 * It provides a menu-driven interface to access different modules of the application.
 */

public class CarConnectMain {
	
	static Scanner scan = new Scanner(System.in);
	/**
     * The main method of the Car Connect application.
     * It displays a menu and handles user inputs to navigate through different modules.
     * @param args Command-line arguments (not used)
     * @throws AdminNotFoundException if admin information is not found
     * @throws VehicleNotFoundException if vehicle information is not found
     */

	public static void main(String[] args) throws AdminNotFoundException, VehicleNotFoundException  {
		
		String input = null;
		do {
			System.out.println("Main Menu ");
			System.out.println("Select a Module ");
			System.out.println("1. Customer Management");
			System.out.println("2. Admin Management");
			System.out.println("3. Vehicle Management");
			System.out.println("4. Reservation Process");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				CustomerView customerView = new CustomerView();
				customerView.displayMenu();
				break;
			}
			case 2: {
				AdminView productView = new AdminView();
				productView.displayMenu();
				break;
			}
			case 3: {
				VehicleView orderView = new VehicleView();
				orderView.displayMenu();
				break;
			}
			case 4: {
				ReservationView orderDetailView = new ReservationView();
				orderDetailView.displayMenu();
				break;
			}
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
			}
			System.out.println("To Continue - Press 'C' | 'c'");
			input = scan.next();
			
		} while (input.equals("c") || input.equals("C"));
		
		
	   
	
		
	}
	
	

}
