package io.halfnhalf.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.halfnhalf.domain.model.User;
import io.halfnhalf.domain.repository.UserRepository;
import io.halfnhalf.service.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public ResponseEntity<User> getUserById(String userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		return ResponseEntity.ok().body(user);

	}
	
	
	public User createUser(User user) {
		return this.userRepository.save(user);
	}
	
	public ResponseEntity<User> updateUser(String userId, User userDetails) 
			throws ResourceNotFoundException{
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setAge(userDetails.getAge());
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	public Map<String, Boolean> deleteUser(String userId) 
			throws ResourceNotFoundException{
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		userRepository.delete(user);
		
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", true);
		
		return response;
		
	}
	
	public List<User> findUsersByLastName(String lastName) throws ResourceNotFoundException {
		
		return userRepository.findUsersByLastName(lastName);

	}
	
	public List<User> findUsersByFirstName(String firstName) throws ResourceNotFoundException {
		
		return userRepository.findUsersByFirstName(firstName);
	}
	
	public List<User> findUsersByFullName(String firstName, String lastName){
		return userRepository.findUsersByFullName(firstName, lastName);
	}

	
	public List<User> findUsersByAge(int age){
		
		return userRepository.findUsersByAge(age);
	}
	
	public List<User> findUsersByAgeAndLastName(int age, String lastName){
		
		return userRepository.findUsersByAgeAndLastName(age, lastName);
		
	}
	
	public List<User> findUsersByFullNameAndAge(int age, String firstName, String lastName){
		return userRepository.findUsersByFullNameAndAge(age, firstName, lastName);
	}

	public List<User> findUsersByAgeAndFirstName(int age, String firstName) {
		return userRepository.findUsersByAgeAndFirstName(age, firstName);
	}


}
