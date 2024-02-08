package com.hexaware.main;




import java.util.Scanner;

import com.hexaware.controller.CustomerService;

import com.hexaware.controller.ICustomerService;


/**
 * The CustomerView class provides a menu-driven interface for customer-related operations.
 */
public class CustomerView {
	
	ICustomerService customerService = new CustomerService();
	Scanner sc = new Scanner(System.in);
	
	
	/**
     * Displays the customer menu and handles user inputs.
     */
           public void displayMenu() {
		
        	   String ch = null;
        	   
        	   do {
        		   System.out.println(" Customer menu ");
        		   System.out.println("Enter your choice");
       			System.out.println("1. Register");
       			System.out.println("2. View Customer Details By ID");
       			System.out.println("3. View Customer Details By Username");
       			System.out.println("4. Update Customers");
       			System.out.println("5. Remove Customers");
       			
       			int choice = sc.nextInt();
    			switch (choice) {
    			case 1:
    				    customerService.registerCustomer();
    				    break;
    				
    			case 2:
    				    customerService.getCustomerById();
    				    break;
    				
    			case 3:
    				    customerService.getCustomerByUserName();
    				    break;
    				    
    			case 4:
    				    customerService.updateCustomer();;
    				    break;
    				    
    			case 5:
    				    customerService.removeCustomer();
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