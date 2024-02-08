package com.hexaware.dao;

import com.hexaware.util.DBConnection;
import com.hexaware.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class CustomerDAO {
  Connection con=DBConnection.getDBConn();
  Statement stmt;
  PreparedStatement ps;
  ResultSet rs;

  public void registerCustomer(Customer cust) {
    try {
     // con = DBConnection.getDBConn();
      ps =
        con.prepareStatement(
          "INSERT INTO Customer" +
          "(firstname, lastname, email, phonenumber, address, username, password, registrationDate)" +
          "VALUES (?,?,?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS
        );
      ps.setString(1, cust.getFirstName());
      ps.setString(2, cust.getLastName());
      ps.setString(3, cust.getEmail());
      ps.setString(4, cust.getPhoneNumber());
      ps.setString(5, cust.getAddress());
      ps.setString(6, cust.getUsername());
      ps.setString(7, cust.getPassword());
   // Convert LocalDate to java.sql.Date
      java.sql.Date sqlregistrationDate = java.sql.Date.valueOf(cust.getRegistrationDate());
      ps.setDate(8, sqlregistrationDate);
      int affectedRows = ps.executeUpdate();
      //System.out.println(no_of_rows + " inserted Successfully !!!" );

      if (affectedRows > 0) {
        // Retrieve auto-generated keys (in this case, customerID)
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
          int generatedCustomerID = generatedKeys.getInt(1);
          cust.setCustomerID(generatedCustomerID);
          System.out.println(
            "Your new Customer ID: " +
            generatedCustomerID +
            "You can create a Reservation using your Customer ID"
          );
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
 //Get an customer by ID
  public Customer getCustomerById(int customerID) {
  	
	Customer customer = null;

	try {
		//con = DBConnection.getDBConn();
	    String sqlQuery = "SELECT * FROM customer WHERE CustomerID = ?";

		ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, customerID);
		rs = ps.executeQuery();

		if (rs.next()) {
			// Convert Date to LocalDate
		    LocalDate registrationDate = rs.getDate("RegistrationDate").toLocalDate();
		   
		    
		    // Create Employee object from ResultSet
		      customer = new Customer(
			    rs.getInt("CustomerID"),
			    rs.getString("FirstName"),
			    rs.getString("LastName"),  
			    rs.getString("Email"),
			    rs.getString("PhoneNumber"),
			    rs.getString("Address"),
			    rs.getString("Username"),
			    rs.getString("Password"),
			    registrationDate);
			    
		}
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	} 
		return customer;
	}
  
//Get an customer by ID
  public Customer getCustomerByUserName(String userName) {
  	
	Customer customer = null;

	try {
		//con = DBConnection.getDBConn();
	    String sqlQuery = "SELECT * FROM customer WHERE UserName = ?";

		ps = con.prepareStatement(sqlQuery);
		ps.setString(1, userName);
		rs = ps.executeQuery();

		if (rs.next()) {
			// Convert Date to LocalDate
		    LocalDate registrationDate = rs.getDate("RegistrationDate").toLocalDate();
		   
		    
		    // Create customer object from ResultSet
		      customer = new Customer(
			    rs.getInt("CustomerID"),
			    rs.getString("FirstName"),
			    rs.getString("LastName"),  
			    rs.getString("Email"),
			    rs.getString("PhoneNumber"),
			    rs.getString("Address"),
			    rs.getString("Username"),
			    rs.getString("Password"),
			    registrationDate);
			    
		}
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	} 
		return customer;
	}
  
//Update an Customer
  public void updateCustomer(Customer customer) {
	try {
	    String query = "UPDATE customer SET FirstName = ?, LastName = ?, "
	    		+ "Email = ?, PhoneNumber = ?,Address=? WHERE CustomerID = ?";
	    ps = con.prepareStatement(query);
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setString(3, customer.getEmail());
		ps.setString(4, customer.getPhoneNumber());
		ps.setString(5, customer.getAddress());
		ps.setInt(6, customer.getCustomerID());
		ps.executeUpdate();
		
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	}
  }
  
//Remove an Customer
  public void removeCustomer(int customerId) {
	try {
	    String query = "DELETE FROM Customer WHERE CustomerID = ?";
	    ps = con.prepareStatement(query);
		ps.setInt(1, customerId);

		ps.executeUpdate();
	 
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	}
  }
  
//Close the database connection
  public void closeConnection() {
	try {
	    if (con != null && !con.isClosed()) {
		con.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	}
  }
}
