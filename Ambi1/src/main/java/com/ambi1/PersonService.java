package com.ambi1;

import java.util.List;

public interface PersonService {
	
	Person addPerson(Person person);
	
	List<Person> getPersons();
	
	String getPersonByEmail(String email);

}
