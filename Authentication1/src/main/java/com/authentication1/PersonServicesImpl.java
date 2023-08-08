package com.authentication1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServicesImpl implements PersonServices {

	@Autowired
	PersonRepo repo;
	
	@Override
	public Person addPerson(Person person) {
		return repo.save(person);
		
	}

	@Override
	public void deletePerson(int pid) {
		Person person=repo.findById(pid).orElseThrow(null);
		if(person != null) {
			repo.delete(person);
		}
	}

}
