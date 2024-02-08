package com.hexaware.main;



import java.util.Scanner;

import com.hexaware.controller.AdminService;

import com.hexaware.controller.IAdminService;
import com.hexaware.exception.AdminNotFoundException;




/**
 * The AdminView class provides a menu-driven interface for admin-related operations.
 */
public class AdminView {
	IAdminService adminService = new AdminService();
	Scanner sc = new Scanner(System.in);
	
	
	/**
     * Displays the admin menu and handles user inputs.
     * @throws AdminNotFoundException if admin information is not found
     */
           public void displayMenu() throws AdminNotFoundException {
		
        	   String ch = null;
        	   
        	   do {
        		   System.out.println(" Admin menu ");
        		   System.out.println("Select a Module ");
       			System.out.println("1. Register");
       			System.out.println("2. View Admin Details By ID");
       			System.out.println("3. View Admin Details By Username");
       			System.out.println("4. Update Admin");
       			System.out.println("5. Remove Admin");
       			
       			int choice = sc.nextInt();
    			switch (choice) {
    			case 1:
    				adminService.registerAdmin();
    				    break;
    				
    			case 2:
    				adminService.getAdminById();
    				    break;
    				
    			case 3:
    				adminService.getAdminByUserName();
    				    break;
    				    
    			case 4:
    				adminService.updateAdmin();;
    				    break;
    				    
    			case 5:
    				adminService.removeAdmin();
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
