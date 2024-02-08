package com.hexaware.exception;

public class VehicleNotFoundException extends Exception {

	public VehicleNotFoundException(String message) {
        super(message);
        System.out.println("Vehicle Not Found");
        
        //UFA DAO line 34
    }
	
	
	
	 @Override
		public String toString() {
			return "VehicleNotFoundException";
		
    }
}
