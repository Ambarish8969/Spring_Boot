package com.vehicledb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicledb.module.Vehicle;
import com.vehicledb.service.VehicleService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // To connect with the Frontend(React.js)
public class VehicleController {

	@Autowired
	VehicleService service;

	@PostMapping("/addvehicle")
	ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v) {
		return new ResponseEntity<Vehicle>(service.addVehicle(v), HttpStatus.CREATED);
	}

	@GetMapping("/getvehiclebyid/{vid}")
	ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer vid) {
		return new ResponseEntity<Vehicle>(service.getVehicleById(vid), HttpStatus.FOUND);
	}

	@GetMapping("/getallvehicles")
	ResponseEntity<List<Vehicle>> getAllVehicles() {
		return new ResponseEntity<List<Vehicle>>(service.getAllVehicles(), HttpStatus.FOUND);
	}

	@GetMapping("/findbyvcolor")
	ResponseEntity<List<Vehicle>> findByVcolor(@RequestHeader String vcolor) {
		return new ResponseEntity<List<Vehicle>>(service.findByVcolor(vcolor), HttpStatus.FOUND);
	}

	@GetMapping("/sortbyvprice")
	ResponseEntity<List<Vehicle>> sortByVprice() {
		return new ResponseEntity<List<Vehicle>>(service.sortByVprice(), HttpStatus.FOUND);
	}

	@GetMapping("/findmorevprice")
	ResponseEntity<List<Vehicle>> findMoreVprice() {
		return new ResponseEntity<List<Vehicle>>(service.findMoreVprice(), HttpStatus.FOUND);
	}

	@GetMapping("/sortbypriceandcolor")
	ResponseEntity<List<Vehicle>> sortByVpriceAndVcolor() {
		return new ResponseEntity<List<Vehicle>>(service.sortByVpriceAndVcolor(), HttpStatus.FOUND);
	}

	@DeleteMapping("/deletevehicle")
	ResponseEntity<Void> deleteVehicle(@RequestHeader Integer vid) {
		service.deleteVehicle(vid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/updatevehicle")
	ResponseEntity<Vehicle> updateVehicle(@RequestHeader Integer vid,@RequestBody Vehicle v) {
		return new ResponseEntity<Vehicle>(service.updateVehicle(vid,v), HttpStatus.OK);
	}
}
