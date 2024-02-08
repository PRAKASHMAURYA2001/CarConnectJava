package com.hexaware.model;

import java.time.LocalDate;

public class Admin {
    private int adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String role;
    private LocalDate joinDate;

    // Default constructor
    public Admin() {
    }

    // Parametrized constructor
    public Admin(int adminId, String firstName, String lastName, String email, String phoneNumber,
                 String username, String password, String role, LocalDate joinDate) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.role = role;
        this.joinDate = joinDate;
    }

    // Getters and setters for all properties

    public int getAdminID() {
        return adminId;
    }

    public void setAdminID(int adminID) {
        this.adminId = adminID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
    
    @Override
   	public String toString() {
   		return "Admin [\nadminID=" + adminId + ", \nfirstName=" + firstName + ", \nlastName=" + lastName + ", \nemail="
   				+ email + ", \nphoneNumber=" + phoneNumber + ", \nusername="+ username+",\npassword=" 
   				+password+" , \nrole= "+role+" ,\njoinDate=" + joinDate+"]\n";
   	}

    // Method to authenticate admin
    public boolean Authenticate(String password) {
        return this.password.equals(password);
    }
}
