package com.hexaware.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.hexaware.dao.AdminDAO;
import com.hexaware.exception.AdminNotFoundException;

import com.hexaware.model.Admin;


public class AdminService implements IAdminService{
	Admin admi = new Admin();
	Scanner sc = new Scanner(System.in);
	AdminDAO adminDAO = new AdminDAO();
	public void registerAdmin() {
		admi = new Admin(); //why we did this?

		System.out.println("--Please enter your details--\n");

		System.out.print("First Name: ");
		String firstName = sc.next();
		admi.setFirstName(firstName);

		System.out.print("Last Name: ");
		String lastName = sc.next();
		admi.setLastName(lastName);

		System.out.print("Email-Id: ");
		String emailAddress = sc.next();
		admi.setEmail(emailAddress);

		System.out.print("Mobile number: ");
		String phoneNumber = sc.next();
		admi.setPhoneNumber(phoneNumber);

		
		System.out.print("Username: ");
		String username = sc.next();
		admi.setUsername(username);
		
		System.out.print("Password: ");
		String password = sc.next();
		admi.setPassword(password);
		
		System.out.print("Enter Role: ");
		String role = sc.next();
		admi.setRole(role);
		
		System.out.print("Date of joining (YYYY-mm-dd): ");
		LocalDate joinDate = LocalDate.parse(sc.next());
		admi.setJoinDate(joinDate);

		//custList.add(cust);

		System.out.println("Admin details were added succesfully!");
		adminDAO.registerAdmin(admi);
	}
	
	@Override
    public void getAdminById()  {
		
		System.out.println("enter Admin id");
		int adminID =sc.nextInt();
		try {
		Admin adminById = adminDAO.getAdminById(adminID);
		
		if (adminById != null) {
            // Display vehicle details
			System.out.println("\n---Customer Details---\n" + adminById);
        } else {
            System.out.println("Vehicle not found.");
        }
    } catch (AdminNotFoundException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
	    
	   
    }
	
	@Override
    public void getAdminByUserName() {
		
		System.out.println("enter Admin UserName");
		String adminuserName =sc.next();
		Admin adminByUserName = adminDAO.getAdminByUserName(adminuserName);
	    System.out.println("\n---Customer Details---\n" + adminByUserName);
	   
    }
	
	@Override
    public void updateAdmin() throws AdminNotFoundException {
		
		
		System.out.print("Enter Admin ID to update: ");
        int updateAdminId = sc.nextInt();
        sc.nextLine(); // Consume newline
        Admin updatedAdmin = adminDAO.getAdminById(updateAdminId);
        if (updatedAdmin != null) {
            System.out.print("Enter new First Name: ");
            updatedAdmin.setFirstName(sc.nextLine());
            System.out.print("Enter new Last Name: ");
            updatedAdmin.setLastName(sc.nextLine());
            System.out.print("Enter new Email: ");
            updatedAdmin.setEmail(sc.nextLine());
            System.out.print("Enter new Phone Number: ");
            updatedAdmin.setPhoneNumber(sc.nextLine());
            System.out.print("Enter new Role: ");
            updatedAdmin.setRole(sc.nextLine());
           
            adminDAO.updateAdmin(updatedAdmin);
            System.out.println("Admin updated successfully");
        } else {
            System.out.println("Admin not found");
        }
	
	}
	
	@Override
    public void removeAdmin() {
	System.out.print("Enter Admin ID to remove: ");
    int removeAdminId = sc.nextInt();
    adminDAO.removeAdmin(removeAdminId);
    System.out.println("Admin removed successfully");
	}
}
