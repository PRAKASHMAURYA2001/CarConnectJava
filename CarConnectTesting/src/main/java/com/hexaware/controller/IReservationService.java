package com.hexaware.controller;



public interface IReservationService {

	public void createReservation();
	
	public void getReservationById();
	
	public void updateReservation();
	
	public void removeReservation();
	
	public void getReservationsByCustomerId();
	
	public void getReservationsByVehicleId();
}
