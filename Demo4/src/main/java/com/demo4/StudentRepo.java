package com.demo4;

import org.springframework.data.repository.CrudRepository;

// crudrepository is used to manipulate the database
public interface StudentRepo extends CrudRepository<Student, Integer>{
	
}
