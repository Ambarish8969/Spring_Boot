package com.demo4;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// crudrepository is used to manipulate the database
public interface StudentRepo extends CrudRepository<Student, Integer>{
	List<Student> findByEmail(String email);
	
//	@Query(value="select * from student where email=?1",nativeQuery=true)
//	List<Student> findByEmail(String email);
	
	@Query(value="select * from student order by phno",nativeQuery=true)
	List<Student> findByPhno();
	
	List<Student> findByName(String name);
}
