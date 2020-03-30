package io.halfnhalf.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.halfnhalf.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT u From User u WHERE u.lastName = ?1")
	public List<User> findUsersByLastName(String lastName);
	
	@Query("SELECT u From User u WHERE u.firstName = ?1")
	public List<User> findUsersByFirstName(String firstName);
	
	@Query("SELECT u From User u WHERE u.age >= ?1")
	public List<User> findUsersByAge(String age);
	
	@Query("SELECT u From User u WHERE u.age >= ?1 AND u.lastName = ?2")
	public List<User> findUsersByAgeAndLastName(String age, String lastName);
	
	
}
