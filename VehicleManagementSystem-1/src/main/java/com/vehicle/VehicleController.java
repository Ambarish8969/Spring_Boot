package com.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class VehicleController {

	@Autowired
	VehicleRepo repo;

	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addvehicle")
	public String addVehicle(HttpSession h1, Vehicle v) {
		h1.setAttribute("vid", v.getVid());
		h1.setAttribute("vehicleName", v.getVehicleName());
		h1.setAttribute("vehicleModel", v.getVehicleModel());
		h1.setAttribute("vehicleColor", v.getVehicleColor());
		return "addvehicle.jsp";
	}

	@RequestMapping("/savevehicle")
	public String saveVehicle(Vehicle v) {
		repo.save(v);
		return "addvehicle.jsp";
	}

	@RequestMapping("/delete")
	public String deleteVehicle() {
		return "deletevehicle.jsp";
	}

	@RequestMapping("/deletevehicle")
	public String deleteVehicleById(Integer vid) {
		Vehicle vehicle = repo.findById(vid).orElse(null);
		if (vehicle != null) {
			repo.deleteById(vid);
			return "deletevehicle.jsp";
		} else {
			return "error.jsp";
		}
	}

	@RequestMapping("/getdetail")
	public String getDetails() {
		return "getdetail.jsp";
	}

	@RequestMapping("/getdetailsbyid")
	public String getDetailsById(HttpSession h1, Integer vid) {
		Vehicle vehicle = repo.findById(vid).orElse(null);
		if (vehicle != null) {
			h1.setAttribute("vid", vehicle.getVid());
			h1.setAttribute("vehicleName", vehicle.getVehicleName());
			h1.setAttribute("vehicleModel", vehicle.getVehicleModel());
			h1.setAttribute("vehicleColor", vehicle.getVehicleColor());
			return "vehicledetails.jsp";
		} else {
			return "error.jsp";
		}
	}

//	@RequestMapping("/allvehicles")
//	public String getAll(HttpSession h1) {
//		Iterable<Vehicle> vehicles=repo.findAll();
//		for(Vehicle vehicle:vehicles) {
//			h1.setAttribute("vid", vehicle.getVid());
//			h1.setAttribute("vehicleName", vehicle.getVehicleName());
//			h1.setAttribute("vehicleModel", vehicle.getVehicleModel());
//			h1.setAttribute("vehicleColor", vehicle.getVehicleColor());
//			return "alldetails.jsp";
//		}
////		h1.setAttribute("details", vehicles);
//		return "alldetails.jsp";
//	}
	
	@RequestMapping("/allvehicles")
	public String getAllTasks(Model model) {
        Iterable<Vehicle> tasks = repo.findAll();
        model.addAttribute("details", tasks);
        return "alldetails.jsp"; // Return the name of the JSP view
    }
}
