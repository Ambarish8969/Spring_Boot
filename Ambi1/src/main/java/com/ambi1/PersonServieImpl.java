package com.ambi1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServieImpl implements PersonService {
	
	@Autowired
	PersonRepo repo;
	
	BCryptPasswordEncoder pwe=new BCryptPasswordEncoder();
	
	@Override
	public Person addPerson(Person person) {
		person.setPassword(pwe.encode(person.getPassword()));
		return repo.save(person);
	}
	
	@Override
	public List<Person> getPersons(){
		List<Person> persons=repo.findAll();
		return persons;
	}

	@Override
	public String getPersonByEmail(String email) {
		return repo.findByEmail(email);
	}
}
