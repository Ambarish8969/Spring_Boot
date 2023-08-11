package com.ambi1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	PersonService service;

	@PostMapping("/addperson")
	ResponseEntity<Person> addPerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(service.addPerson(person), HttpStatus.CREATED);
	}

	@GetMapping("/getpersons")
	ResponseEntity<List<Person>> getPersons() {
		return new ResponseEntity<List<Person>>(service.getPersons(), HttpStatus.FOUND);
	}

	@GetMapping("/authenticate")
	public Boolean validatePerson(@RequestHeader String email, @RequestHeader String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		String password1 = service.getPersonByEmail(email);
		System.out.println(password1);
		if (bCryptPasswordEncoder.matches(password, password1)) {
			return true;
		} else {
			return false;
		}
	}

}
