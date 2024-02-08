package com.hexaware.model;

import java.time.LocalDate;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;
    private LocalDate registrationDate;

    // Default constructor
    public Customer() {
    }

    // Parametrized constructor
    public Customer(int customerId, String firstName, String lastName, String email, String phoneNumber,
                    String address, String username, String password, LocalDate registrationDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    // Getters and setters for all properties

    public int getCustomerID() {
        return customerId;
    }

    public void setCustomerID(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    @Override
	public String toString() {
		return "Customer [\ncustomerID=" + customerId + ", \nfirstName=" + firstName + ", \nlastName=" + lastName + ", \nemail="
				+ email + ", \nphoneNumber=" + phoneNumber + ", \naddress=" + address + ",\nusername="+ username+",\npassword=" 
				+password+" ,\nregistrationDate=" + registrationDate+"]\n";
	}

    // Method to authenticate customer
    public boolean Authenticate(String password) {
        return this.password.equals(password);
    }
}
