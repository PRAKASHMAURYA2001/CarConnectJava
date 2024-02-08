package com.hexaware.controller;


import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.dao.CustomerDAO;
import com.hexaware.model.Customer;

public class CustomerService implements ICustomerService {
	Customer cust = new Customer();
	Scanner sc = new Scanner(System.in);
	CustomerDAO customerDAO = new CustomerDAO();
	
	public void registerCustomer() {
		//cust = new Customer(); //why we did this?

		System.out.println("--Please enter your details--\n");

		System.out.print("First Name: ");
		String firstName = sc.next();
		cust.setFirstName(firstName);

		System.out.print("Last Name: ");
		String lastName = sc.next();
		cust.setLastName(lastName);

		System.out.print("Email-Id: ");
		String emailAddress = sc.next();
		cust.setEmail(emailAddress);

		System.out.print("Mobile number: ");
		String phoneNumber = sc.next();
		cust.setPhoneNumber(phoneNumber);

		System.out.print("Address: ");
		String address = sc.next();
		cust.setAddress(address);
		
		System.out.print("Username: ");
		String username = sc.next();
		cust.setUsername(username);
		
		System.out.print("Password: ");
		String password = sc.next();
		cust.setPassword(password);
		
		System.out.print("Date of Registration (YYYY-mm-dd): ");
		LocalDate registrationDate = LocalDate.parse(sc.next());
		cust.setRegistrationDate(registrationDate);

		//custList.add(cust);

		System.out.println("Customer details were added succesfully!");
		customerDAO.registerCustomer(cust);
	}
	//@Override
	//public void viewCustomer() {
		//System.out.println(custList);
	//	dao.showCustomerDeails();
	
	@Override
    public void getCustomerById() {
		
		    
			System.out.println("enter customer id");
			int customerID =sc.nextInt();
	    Customer customerById = customerDAO.getCustomerById(customerID);
	    System.out.println("\n---Customer Details---\n" + customerById);
	   
    }
	
	@Override
    public void getCustomerByUserName() {
		
		System.out.println("enter customer UserName");
		String customeruserName =sc.next();
	    Customer customerByUserName = customerDAO.getCustomerByUserName(customeruserName);
	    System.out.println("\n---Customer Details---\n" + customerByUserName);
	   
    }
	
	@Override
    public void updateCustomer() {
		
		
		System.out.print("Enter Customer ID to update: ");
        int updateCustomerId = sc.nextInt();
        sc.nextLine(); // Consume newline
        Customer updatedCustomer = customerDAO.getCustomerById(updateCustomerId);
        if (updatedCustomer != null) {
            System.out.print("Enter new First Name: ");
            updatedCustomer.setFirstName(sc.nextLine());
            System.out.print("Enter new Last Name: ");
            updatedCustomer.setLastName(sc.nextLine());
            System.out.print("Enter new Email: ");
            updatedCustomer.setEmail(sc.nextLine());
            System.out.print("Enter new Phone Number: ");
            updatedCustomer.setPhoneNumber(sc.nextLine());
            System.out.print("Enter new Address: ");
            updatedCustomer.setAddress(sc.nextLine());
           
            customerDAO.updateCustomer(updatedCustomer);
            System.out.println("Customer updated successfully");
        } else {
            System.out.println("Customer not found");
        }
	
	}
	
	@Override
    public void removeCustomer() {
	System.out.print("Enter Customer ID to remove: ");
    int removeCustomerId = sc.nextInt();
    customerDAO.removeCustomer(removeCustomerId);
    System.out.println("Customer removed successfully");
	}
}