package com.hexaware.main;
 
import java.util.Scanner;


import com.hexaware.controller.IVehicleService;
import com.hexaware.controller.VehicleService;
import com.hexaware.exception.VehicleNotFoundException;


/**
 * The VehicleView class provides a menu-driven interface for vehicle-related operations.
 */
public class VehicleView {

	IVehicleService vehicleService = new VehicleService();
	Scanner sc = new Scanner(System.in);
	
	/**
     * Displays the vehicle menu and handles user inputs.
     * @throws VehicleNotFoundException if vehicle information is not found
     */
           public void displayMenu() throws VehicleNotFoundException  {
		
        	   String ch = null;
        	   
        	   do {
        		   System.out.println(" Vehicle menu ");
        		   System.out.println("Enter your choice");
       			System.out.println("1. Register a new Vehicle");
       			System.out.println("2. View Vehicle Details By ID");
       			System.out.println("3. View Available Vehicle Details");
       			System.out.println("4. Update Vehicle");
       			System.out.println("5. Remove Vehicle");
       			
       			int choice = sc.nextInt();
    			switch (choice) {
    			case 1:
    				vehicleService.addVehicle();;
    				    break;
    				
    			case 2:
    				vehicleService.getVehicleById();
    				    break;
    				
    			case 3:
    				vehicleService.getAvailableVehicles();
    				    break;
    				    
    			case 4:
    				vehicleService.updateVehicle();
    				    break;
    				    
    			case 5:
    				vehicleService.removeVehicle();
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
