package com.hexaware.dao;

import com.hexaware.util.DBConnection;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
  Connection con=DBConnection.getDBConn();
  Statement stmt;
  PreparedStatement ps;
  ResultSet rs;

  public void addVehicle(Vehicle vehi) {
    try {
     // con = DBConnection.getDBConn();
      ps =
        con.prepareStatement(
          "INSERT INTO Vehicle" +
          "(Model, Make, Year, Color,  RegistrationNumber, Availability, DailyRate)" +
          "VALUES (?,?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS
        );
      ps.setString(1, vehi.getModel());
      ps.setString(2, vehi.getMake());
      ps.setInt(3, vehi.getYear());
      ps.setString(4, vehi.getColor());
      ps.setString(5, vehi.getRegistrationNumber());
      ps.setBoolean(6, vehi.getAvailability());
      ps.setDouble(7, vehi.getDailyRate());
   
      int affectedRows = ps.executeUpdate();
      //System.out.println(no_of_rows + " inserted Successfully !!!" );

      if (affectedRows > 0) {
        // Retrieve auto-generated keys (in this case, VehicleID)
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
          int generatedVehicleID = generatedKeys.getInt(1);
          vehi.setVehicleID(generatedVehicleID);
          System.out.println(
            "Your new Vehicle ID: " +
            generatedVehicleID +
            "You can Track your Vehicle Information by ID"
          );
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  // Get all Available vehicle
  public List<Vehicle> getAvailableVehicles() {
	List<Vehicle> vehicles = new ArrayList<>();

	try {
	    String query = "SELECT * FROM vehicle WHERE Availability=true";
	    stmt = con.createStatement();
		rs = stmt.executeQuery(query);

		while (rs.next()) {
			
			
		  
		    
		    // Create Vehicle objects from ResultSet and add to the list
		    Vehicle vehicle = new Vehicle(
				    rs.getInt("VehicleId"),
				    rs.getString("Model"),
				    rs.getString("Make"),
				    rs.getInt("Year"),
				    rs.getString("Color"),
				    rs.getString("RegistrationNumber"),
				    rs.getBoolean("Availability"),
				    rs.getDouble("DailyRate"));
				   
				   
		    vehicles.add(vehicle);
		}
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	}

	return vehicles;
	
  }
//Get an Vehicle by ID
  public Vehicle getVehicleById(int vehicleID) throws VehicleNotFoundException {
  	
	  Vehicle vehicle = null;

	try {
		//con = DBConnection.getDBConn();
	    String sqlQuery = "SELECT * FROM Vehicle WHERE VehicleID = ?";

		ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, vehicleID);
		rs = ps.executeQuery();

		if (rs.next()) {
			 
		    // Create Vehicle object from ResultSet
			vehicle = new Vehicle(
			    rs.getInt("VehicleID"),
			    rs.getString("Model"),
			    rs.getString("Make"),  
			    rs.getInt("Year"),
			    rs.getString("Color"),
			    rs.getString("RegistrationNumber"),
			    rs.getBoolean("Availability"),
			    rs.getDouble("DailyRate"));
			    		    
		}else {
            throw new VehicleNotFoundException("Vehicle with ID " + vehicleID + " not found");
        }
	    
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	} 
		return vehicle;
	}
  

//Update an vehicle
  public void updateVehicle(Vehicle vehicle) {
	try {
	    String query = "UPDATE Vehicle SET Color = ?, Availability = ?, "
	    		+ "DailyRate = ? WHERE VehicleID = ?";
	    ps = con.prepareStatement(query);
		ps.setString(1,vehicle.getColor());
		ps.setBoolean(2, vehicle.getAvailability());
		ps.setDouble(3, vehicle.getDailyRate());
		ps.setInt(4, vehicle.getVehicleID());
		ps.executeUpdate();
		
	} catch (SQLException e) {
	    e.printStackTrace();
	    // Handle SQL exception
	}
  }
  
//Remove an vehicle
  public void removeVehicle(int vehicleId) {
	try {
	    String query = "DELETE FROM vehicle WHERE vehicleID = ?";
	    ps = con.prepareStatement(query);
		ps.setInt(1, vehicleId);

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
