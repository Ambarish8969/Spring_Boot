package com.vehicledb.service;

import java.util.List;

import com.vehicledb.module.Vehicle;

public interface VehicleService {
	Vehicle addVehicle(Vehicle v);
	
	Vehicle updateVehicle(Integer vid,Vehicle v);
	
	Vehicle getVehicleById(Integer vid);
	
	List<Vehicle> getAllVehicles();
	
	List<Vehicle> findByVcolor(String vcolor);
	
	List<Vehicle> sortByVprice();
	
	List<Vehicle> findMoreVprice();
	
	List<Vehicle> sortByVpriceAndVcolor();
	
	void deleteVehicle(Integer vid);
}
