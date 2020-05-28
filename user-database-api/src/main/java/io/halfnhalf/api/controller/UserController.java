package io.halfnhalf.api.controller;

import java.util.List;

import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.halfnhalf.domain.model.User;
import io.halfnhalf.service.exception.ResourceNotFoundException;
import io.halfnhalf.service.service.UserService;

/**
 * RestController handles all communication between client and database via HTTP-requests.
 * Uses methods implemented in the UserService class and specifies endpoints where said methods 
 * can be be reached.
 * @author jonatan berko, julius hopf
 *
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//http://localhost:8081/users/{id}
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userId) 
			throws ResourceNotFoundException{
		return userService.getUserById(userId);
	}
	
	//http://localhost:8081/lastName/{lastName}
	@GetMapping("/lastName/{lastName}")
	public List<User> findUsersByLastName(@PathVariable(value = "lastName") String lastName) 
			throws ResourceNotFoundException{
		return userService.findUsersByLastName(lastName);
	}
	//http://localhost:8081/firstName/{firstName}
	@GetMapping("/firstName/{firstName}")
	public List<User> findUserByFirstName(@PathVariable(value = "firstName") String firstName) 
			throws ResourceNotFoundException{
		return userService.findUsersByFirstName(firstName);
	}
	
	//http://localhost:8081/age/{age}
	@GetMapping("/age/{age}")
	public List<User> findUsersByAge(@PathVariable(value = "age") int age){
		
		return userService.findUsersByAge(age);
	}
	
	//http://localhost:8081/fullName/?firstName={firstName}&lastName={lastName}
	@GetMapping("/fullName/")
	public List<User> findUsersByFullName(@RequestParam String firstName, @RequestParam String lastName){
		return userService.findUsersByFullName(firstName, lastName);
	}
	
	//http://localhost:8081/firstNameAndAge/?firstName={firstName}&age={age}
	@GetMapping("/firstNameAndAge/")
	public List<User> findUsersByAgeAndfirstName(@RequestParam int age, @RequestParam String firstName) {

		return userService.findUsersByAgeAndFirstName(age, firstName);

	}
	
	//http://localhost:8081/lastNameAndAge/?lastName={lastName}&age={age}
	@GetMapping("/lastNameAndAge/")
	public List<User> findUsersByAgeAndLastName(@RequestParam int age, @RequestParam String lastName){
		
		return userService.findUsersByAgeAndLastName(age, lastName);
		
	}
	
	//http://localhost:8081/fullName/?firstName={firstName}&lastName={lastName}&age={age}
	@GetMapping("/fullNameAndAge/")
	public List<User> findUsersByFullNameAndAge(@RequestParam int age, @RequestParam String firstName,
												@RequestParam String lastName){
		return userService.findUsersByFullNameAndAge(age, firstName, lastName);
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
	 
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException{
		
		return userService.updateUser(userId, userDetails);		
	}
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") String userId) 
			throws ResourceNotFoundException{
		return userService.deleteUser(userId);
		
	}
	
	
	
}
