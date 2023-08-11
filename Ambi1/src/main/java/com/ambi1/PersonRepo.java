package com.ambi1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepo extends JpaRepository<Person, Integer> {

	@Query(value = "select password from Person where email=?1", nativeQuery = true)
	String findByEmail(String email);

}
