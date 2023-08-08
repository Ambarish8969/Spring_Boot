package com.authentication1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class PersonController {

	@Autowired
	PersonServicesImpl service;

	@PostMapping("/addperson")
	ResponseEntity<Person> addPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(service.addPerson(person), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteperson/{pid}")
	ResponseEntity<Void> deletePerson(@PathVariable Integer pid) {
		service.deletePerson(pid);
	    return new ResponseEntity<>(HttpStatus.OK);
	}

}
