package com.studentdb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentdb.module.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query(value = "select * from Student where marks=?1", nativeQuery = true)
	List<Student> findByMarks(Integer marks);
	
}
