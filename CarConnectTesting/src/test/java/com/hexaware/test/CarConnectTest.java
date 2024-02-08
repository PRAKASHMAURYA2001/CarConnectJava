package com.hexaware.test;

import static org.junit.Assert.assertEquals;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.hexaware.dao.*;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.model.Admin;
import com.hexaware.model.Customer;
import com.hexaware.model.Reservation;
import com.hexaware.model.Vehicle;
import com.hexaware.util.DBConnection;

public class CarConnectTest extends DBConnection {
     
	 private CustomerDAO customerDAO;
	 private AdminDAO adminDAO;
	 private VehicleDAO vehicleDAO;
	 private ReservationDAO reservationDAO;

	@Before
	public void setUp() {
		customerDAO =new CustomerDAO();
	    adminDAO = new AdminDAO();
	    vehicleDAO = new VehicleDAO();
	    reservationDAO = new ReservationDAO();
	    System.out.println("Set up called before the test case");
	}
	 @Test
	    public void testGetCustomerById() throws SQLException {
	        // Mock ResultSet data
	        

	        // Call the method being tested
	        Customer customer = customerDAO.getCustomerById(1001);

	        // Verify the results
	        assertEquals(1001, customer.getCustomerID());
	        assertEquals("John", customer.getFirstName());
	        assertEquals("Doe", customer.getLastName());
	        assertEquals("john.doe@gmail.com", customer.getEmail());
	        assertEquals("1234567890", customer.getPhoneNumber());
	        assertEquals("Mumbai", customer.getAddress());
	        assertEquals("john_doe", customer.getUsername());
	        assertEquals("doe", customer.getPassword());
	       
	    }
	 @Test
	    public void testGetAdminById_Success() throws SQLException, AdminNotFoundException {
	       

	        // Call the method being tested
	        Admin admin = adminDAO.getAdminById(1);

	        // Verify the results
	        assertEquals(1, admin.getAdminID());
	        assertEquals("Tejas", admin.getFirstName());
	        assertEquals("Josh", admin.getLastName());
	        assertEquals("tejasjosh@gmail.com", admin.getEmail());
	        assertEquals("9998887777", admin.getPhoneNumber());
	        assertEquals("tejas", admin.getUsername());
	        assertEquals("josh", admin.getPassword());
	        assertEquals("manager", admin.getRole());
	       
	    }

	   
	 @Test
	    public void testGetVehicleById_Success() throws SQLException, VehicleNotFoundException {
	       
	        // Call the method being tested
	        Vehicle vehicle = vehicleDAO.getVehicleById(101);

	        // Verify the results
	       
	        assertEquals(101, vehicle.getVehicleID());
	        assertEquals("Civic", vehicle.getModel());
	        assertEquals("Honda", vehicle.getMake());
	        assertEquals(2022, vehicle.getYear());
	        assertEquals("Blue", vehicle.getColor());
	        assertEquals("ABC123", vehicle.getRegistrationNumber());
	        assertEquals(false, vehicle.getAvailability());
	        assertEquals(50.0, vehicle.getDailyRate(), 0.01);
	    }
	 
	 @Test
	    public void testGetReservationById_Success() throws SQLException {
	       

	        // Call the method being tested
	        Reservation reservation = reservationDAO.getReservationById(10001);

	        // Verify the results
	        
	        assertEquals(10001, reservation.getReservationID());
	        assertEquals(1001, reservation.getCustomerID());
	        assertEquals(101, reservation.getVehicleID());
	        assertEquals(LocalDateTime.of(2024, 01, 25,  8, 00, 00), reservation.getStartDate());
	        assertEquals(LocalDateTime.of(2024, 01, 27, 18, 00, 00), reservation.getEndDate());
	        assertEquals(120.0, reservation.getTotalCost(), 0.01);
	        assertEquals("confirmed", reservation.getStatus());
	    }
	 
	 
	 @Test
	    public void testGetReservationsByCustomerId_Success() throws SQLException {
	      
	        // Call the method being tested
	        List<Reservation> reservations = reservationDAO.getReservationsByCustomerId(1003);

	        // Verify the results
	       
	        assertEquals(1, reservations.size());
	        Reservation reservation = reservations.get(0);
	        assertEquals(10003, reservation.getReservationID());
	        assertEquals(1003, reservation.getCustomerID());
	        assertEquals(102, reservation.getVehicleID());
	        assertEquals(LocalDateTime.of(2024, 01, 30, 12, 00, 00), reservation.getStartDate());
	        assertEquals(LocalDateTime.of(2024, 02, 01, 12, 00, 00), reservation.getEndDate());
	        assertEquals(180.0, reservation.getTotalCost(), 0.01);
	        assertEquals("completed", reservation.getStatus());
	    }
	 
	 @After
		public void tearDown() {
			System.out.println("Tear Down called after the test case");
			
		}
	 
	
}
