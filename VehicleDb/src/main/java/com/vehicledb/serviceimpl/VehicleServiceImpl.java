package com.vehicledb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicledb.exceptions.ResourceNotFoundException;
import com.vehicledb.module.Vehicle;
import com.vehicledb.repo.VehicleRepo;
import com.vehicledb.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public Vehicle updateVehicle(Integer vid,Vehicle v) {
		Vehicle vehicle = repo.findById(vid).orElse(null);
		if (vehicle != null) {
			vehicle.setVname(v.getVname());
			vehicle.setVprice(v.getVprice());
			vehicle.setVmodel(v.getVmodel());
			vehicle.setVcolor(v.getVcolor());
			return repo.save(vehicle);
		} else {
			throw new ResourceNotFoundException("Vehicle", "id", vid);
		}

	}

	@Override
	public Vehicle getVehicleById(Integer vid) {
		return repo.findById(vid).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", vid));
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = repo.findAll();
		return vehicles;
	}

	@Override
	public void deleteVehicle(Integer vid) {
		repo.deleteById(vid);
	}

	@Override
	public List<Vehicle> findByVcolor(String vcolor) {
		List<Vehicle> vehicles = repo.findByVcolor(vcolor);
		return vehicles;
	}

	@Override
	public List<Vehicle> sortByVprice() {
		List<Vehicle> vehicles = repo.sortByVprice();
		return vehicles;
	}

	@Override
	public List<Vehicle> findMoreVprice() {
		List<Vehicle> vehicles = repo.findMoreVprice();
		return vehicles;
	}

	@Override
	public List<Vehicle> sortByVpriceAndVcolor() {
		List<Vehicle> vehicles = repo.sortByVpriceAndVcolor();
		return vehicles;
	}

}
