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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.halfnhalf.domain.model.User;
import io.halfnhalf.service.exception.ResourceNotFoundException;
import io.halfnhalf.service.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userId) 
			throws ResourceNotFoundException{
		return userService.getUserById(userId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<User> getUserByLastName(@RequestParam(value = "lastName") String lastName) 
			throws ResourceNotFoundException{
		return userService.getUserByLastName(lastName);
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
