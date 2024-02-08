package com.hexaware.controller;

import com.hexaware.exception.AdminNotFoundException;

public interface IAdminService {
	
    public void getAdminById() throws AdminNotFoundException;
	
	public void getAdminByUserName();

	public void registerAdmin();
	
    public void updateAdmin() throws AdminNotFoundException;
    
    public void removeAdmin();
}
