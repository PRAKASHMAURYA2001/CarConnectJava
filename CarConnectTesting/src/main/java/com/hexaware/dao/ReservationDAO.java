package com.hexaware.dao;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.hexaware.model.Reservation;
import com.hexaware.util.DBConnection;

public class ReservationDAO {
	 Connection con=DBConnection.getDBConn();
	  Statement stmt;
	  PreparedStatement ps;
	  ResultSet rs;

	  public void createReservation(Reservation rese) {
	    try {
	     // con = DBConnection.getDBConn();
	      ps =
	        con.prepareStatement(
	          "INSERT INTO Reservation" +
	          "(CustomerID, VehicleID, StartDate,EndDate)" +
	          "VALUES (?,?,?,?)",
	          Statement.RETURN_GENERATED_KEYS
	        );
	      ps.setInt(1, rese.getCustomerID());
	      ps.setInt(2, rese.getVehicleID());
	   // Convert LocalDate to java.sql.Date
	      Timestamp sqlStartDate = Timestamp.valueOf(rese.getStartDate());
	      ps.setTimestamp(3, sqlStartDate);
	   // Convert LocalDate to java.sql.Date
	      Timestamp sqlEndDate = Timestamp.valueOf(rese.getEndDate());
	      ps.setTimestamp(4, sqlEndDate);
	     
	      int affectedRows = ps.executeUpdate();
	      //System.out.println(no_of_rows + " inserted Successfully !!!" );

	      if (affectedRows > 0) {
	        // Retrieve auto-generated keys (in this case, customerID)
	        ResultSet generatedKeys = ps.getGeneratedKeys();
	        if (generatedKeys.next()) {
	          int generatedReservationID = generatedKeys.getInt(1);
	          rese.setReservationID(generatedReservationID);
	         
	          System.out.println(
	            "Your new Reservation ID: " +
	            generatedReservationID 
	           
	          );
	          
	        ps =
	      	      con.prepareStatement(
	      	          "SELECT TotalCost,Status FROM Reservation WHERE ReservationID=?"  ); 
	        
	        ps.setInt(1, generatedReservationID);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				 double totalCost = rs.getDouble("TotalCost");
				    String status = rs.getString("Status");

				    System.out.println(" And your Total Cost is: " + totalCost);
				    System.out.println("Status of your Reservation: " + status);
				   
				    
				    
			}
	        }
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  
	//Get an Reservation by ID
	  public Reservation getReservationById(int reservationID) {
	  	
		  Reservation reservation = null;

		try {
			//con = DBConnection.getDBConn();
		    String sqlQuery = "SELECT * FROM Reservation WHERE ReservationID = ?";

			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, reservationID);
			rs = ps.executeQuery();

			if (rs.next()) {
				// Convert Date to LocalDate
				Timestamp sqlTimestamp = rs.getTimestamp("StartDate");
				LocalDateTime StartDate = sqlTimestamp.toLocalDateTime();
				Timestamp sqlTimestamp1 = rs.getTimestamp("EndDate");
				LocalDateTime EndDate = sqlTimestamp1.toLocalDateTime();
			    // Create Employee object from ResultSet
			    reservation = new Reservation(
				    rs.getInt("ReservationID"),
				    rs.getInt("CustomerID"),
				    rs.getInt("VehicleID"),  
				    StartDate,
				    EndDate,
				    rs.getDouble("TotalCost"),
				    rs.getString("Status"));
				   
				   }
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		} 
			return reservation;
		}
	  
	//Get an Reservations  by CustomerID
	  public List<Reservation> getReservationsByCustomerId(int customerID) {
	  	
		  List<Reservation> reservations = new ArrayList<>();

		Reservation reservation=null;
		try {
			//con = DBConnection.getDBConn();
		    String sqlQuery = "SELECT * FROM Reservation WHERE CustomerID = ?";

			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, customerID);
			rs = ps.executeQuery();

			while (rs.next()) {
				// Convert Date to LocalDate
				Timestamp sqlTimestamp = rs.getTimestamp("StartDate");
				LocalDateTime StartDate = sqlTimestamp.toLocalDateTime();
				Timestamp sqlTimestamp1 = rs.getTimestamp("EndDate");
				LocalDateTime EndDate = sqlTimestamp1.toLocalDateTime();
			    // Create Employee object from ResultSet
			    reservation = new Reservation(
				    rs.getInt("ReservationID"),
				    rs.getInt("CustomerID"),
				    rs.getInt("VehicleID"),  
				    StartDate,
				    EndDate,
				    rs.getDouble("TotalCost"),
				    rs.getString("Status"));
			    reservations.add(reservation);
				   }
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		} 
			return reservations;
		}
	  
	//Update an Reservation
	  public void updateReservation(Reservation reservation) {
		try {
		    String query = "UPDATE Reservation SET VehicleID = ?, StartDate = ?, "
		    		+ "EndDate = ? WHERE ReservationID = ?";
		    ps = con.prepareStatement(query);
		    ps.setInt(1, reservation.getVehicleID());
		    // Convert LocalDate to java.sql.Date
		      Timestamp sqlStartDate = Timestamp.valueOf(reservation.getStartDate());
		      ps.setTimestamp(2, sqlStartDate);
		   // Convert LocalDate to java.sql.Date
		      Timestamp sqlEndDate = Timestamp.valueOf(reservation.getEndDate());
		      ps.setTimestamp(3, sqlEndDate);
		      int reservationId = reservation.getReservationID();
		      ps.setInt(4,reservationId );
			ps.executeUpdate();
			
			 ps =
		      	      con.prepareStatement(
		      	          "SELECT TotalCost,Status FROM Reservation WHERE ReservationID=?"  ); 
		        
		        ps.setInt(1, reservationId);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					
					 double totalCost = rs.getDouble("TotalCost");
					    String status = rs.getString("Status");

					    System.out.println(" And your Total Cost is: " + totalCost);
					    System.out.println("Status of your Reservation: " + status);
				}   
			
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		}
	  }
	  
	//Remove an Reservation
	  public void removeReservation(int reservationId) {
		try {
		    String query = "DELETE FROM Reservation WHERE ReservationID = ?";
		    ps = con.prepareStatement(query);
			ps.setInt(1, reservationId);

			ps.executeUpdate();
		 
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		}
	  }
	  
	  
	//Get an Reservations  by VehicleID
	  public List<Reservation> getReservationsByVehicleId(int vehicleID) {
	  	
		  List<Reservation> reservations = new ArrayList<>();

		Reservation reservation=null;
		try {
			//con = DBConnection.getDBConn();
		    String sqlQuery = "SELECT * FROM Reservation WHERE VehicleID = ?";

			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, vehicleID);
			rs = ps.executeQuery();

			while (rs.next()) {
				// Convert Date to LocalDate
				Timestamp sqlTimestamp = rs.getTimestamp("StartDate");
				LocalDateTime StartDate = sqlTimestamp.toLocalDateTime();
				Timestamp sqlTimestamp1 = rs.getTimestamp("EndDate");
				LocalDateTime EndDate = sqlTimestamp1.toLocalDateTime();
			    // Create Employee object from ResultSet
			    reservation = new Reservation(
				    rs.getInt("ReservationID"),
				    rs.getInt("CustomerID"),
				    rs.getInt("VehicleID"),  
				    StartDate,
				    EndDate,
				    rs.getDouble("TotalCost"),
				    rs.getString("Status"));
			    reservations.add(reservation);
				   }
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle SQL exception
		} 
			return reservations;
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
