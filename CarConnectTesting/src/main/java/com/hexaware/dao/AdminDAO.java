package com.hexaware.dao;

import com.hexaware.util.DBConnection;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class AdminDAO {
  Connection con=DBConnection.getDBConn();
  Statement stmt;
  PreparedStatement ps;
  ResultSet rs;

  public void registerAdmin(Admin adm) {
    try {
     // con = DBConnection.getDBConn();
      ps =
        con.prepareStatement(
          "INSERT INTO Admin" +
          "(firstname, lastname, email, phonenumber,  username, password,role, joinDate)" +
          "VALUES (?,?,?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS
        );
      ps.setString(1, adm.getFirstName());
      ps.setString(2, adm.getLastName());
      ps.setString(3, adm.getEmail());
      ps.setString(4, adm.getPhoneNumber());
      ps.setString(5, adm.getUsername());
      ps.setString(6, adm.getPassword());
      ps.setString(7, adm.getRole());
   // Convert LocalDate to java.sql.Date
      java.sql.Date sqljoinDate = java.sql.Date.valueOf(adm.getJoinDate());
      ps.setDate(8, sqljoinDate);
      int affectedRows = ps.executeUpdate();
      //System.out.println(no_of_rows + " inserted Successfully !!!" );

      if (affectedRows > 0) {
        // Retrieve auto-generated keys (in this case, customerID)
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
          int generatedAdminID = generatedKeys.getInt(1);
          adm.setAdminID(generatedAdminID);
          System.out.println(
            "Your new Admin ID: " +
            generatedAdminID 
            
          );
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
 
//Get an Admin by ID
  public Admin getAdminById(int adminID) throws AdminNotFoundException {
  	
	  Admin admin = null;

	try {
		//con = DBConnection.getDBConn();
	    String sqlQuery = "SELECT * FROM admin WHERE AdminID = ?";

		ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, adminID);
		rs = ps.executeQuery();

		if (rs.next()) {
			// Convert Date to LocalDate
		    LocalDate joinDate = rs.getDate("JoinDate").toLocalDate();
		   
		    
		    // Create Admin object from ResultSet
		        admin = new Admin(
			    rs.getInt("AdminID"),
			    rs.getString("FirstName"),
			    rs.getString("LastName"),  
			    rs.getString("Email"),
			    rs.getString("PhoneNumber"),
			    rs.getString("Username"),
			    rs.getString("Password"),
			    rs.getString("Role"),
			    joinDate);
			    
		}else {
            throw new AdminNotFoundException("Admin with ID " + adminID + " not found");
            
	    
		}} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	} 
		return admin;
	}
  
//Get an customer by ID
  public Admin getAdminByUserName(String userName) {
  	
	  Admin admin = null;

	try {
		//con = DBConnection.getDBConn();
	    String sqlQuery = "SELECT * FROM admin WHERE UserName = ?";

		ps = con.prepareStatement(sqlQuery);
		ps.setString(1, userName);
		rs = ps.executeQuery();

		if (rs.next()) {
			// Convert Date to LocalDate
		    LocalDate joinDate = rs.getDate("JoinDate").toLocalDate();
		   
		    
		    // Create customer object from ResultSet
		        admin = new Admin(
			    rs.getInt("AdminID"),
			    rs.getString("FirstName"),
			    rs.getString("LastName"),  
			    rs.getString("Email"),
			    rs.getString("PhoneNumber"),
			    rs.getString("Username"),
			    rs.getString("Password"),
			    rs.getString("Role"),
			    joinDate);
			    
		}
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	} 
		return admin;
	}
  
//Update an Admin
  public void updateAdmin(Admin admin) {
	try {
	    String query = "UPDATE admin SET FirstName = ?, LastName = ?, "
	    		+ "Email = ?, PhoneNumber = ?,Role=? WHERE AdminID = ?";
	    ps = con.prepareStatement(query);
		ps.setString(1, admin.getFirstName());
		ps.setString(2, admin.getLastName());
		ps.setString(3, admin.getEmail());
		ps.setString(4, admin.getPhoneNumber());
		ps.setString(5, admin.getRole());
		ps.setInt(6, admin.getAdminID());
		ps.executeUpdate();
		
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	}
  }
  
//Remove an Admin
  public void removeAdmin(int adminId) {
	try {
	    String query = "DELETE FROM Admin WHERE AdminID = ?";
	    ps = con.prepareStatement(query);
		ps.setInt(1, adminId);

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
