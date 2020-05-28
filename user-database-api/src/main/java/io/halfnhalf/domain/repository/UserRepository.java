package io.halfnhalf.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.halfnhalf.domain.model.User;

/**
 * UserRepository handles communication with database, conversion of types between 
 * POJO and database entry and specifies custom SQL-queries that are not supported 
 * by JPARepository from scratch.
 * 
 * @author jonatan berko, julius hopf
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT u From User u WHERE u.lastName = ?1")
	public List<User> findUsersByLastName(String lastName);
	
	@Query("SELECT u From User u WHERE u.firstName = ?1")
	public List<User> findUsersByFirstName(String firstName);
	
	@Query("SELECT u From User u WHERE CAST(u.age as int) >= ?1")
	public List<User> findUsersByAge(int age);
	
	@Query("SELECT u From User u WHERE u.firstName = ?1 AND u.lastName = ?2")
	public List<User> findUsersByFullName(String firstName, String lastName);
	
	@Query("SELECT u From User u WHERE CAST(u.age as int) >= ?1 AND u.firstName = ?2")
	public List<User> findUsersByAgeAndFirstName(int age, String firstName);
	
	@Query("SELECT u From User u WHERE CAST(u.age as int) >= ?1 AND u.lastName = ?2")
	public List<User> findUsersByAgeAndLastName(int age, String lastName);
	
	@Query("SELECT u From User u WHERE CAST(u.age as int) >= ?1 AND u.firstName =?2 AND u.lastName = ?3")
	public List<User> findUsersByFullNameAndAge(int age, String firstName, String lastName);	
	
}
