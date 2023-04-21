package com.vehicledb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicledb.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	@Query(value = "select * from Vehicle where vcolor=?1", nativeQuery = true)
	List<Vehicle> findByVcolor(String vcolor);

	@Query(value = "select * from Vehicle order by vprice asc", nativeQuery = true)
	List<Vehicle> sortByVprice();

	@Query(value = "select * from Vehicle where vprice>=1000000", nativeQuery = true)
	List<Vehicle> findMoreVprice();
	
	@Query(value = "select * from Vehicle order by vprice asc,vcolor asc", nativeQuery = true)
	List<Vehicle> sortByVpriceAndVcolor();
}
