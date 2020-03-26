package io.halfnhalf.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.halfnhalf.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query(value ="select * from users u where u.last_name = :lastName", nativeQuery = true)
	public User findUserByLastName(@Param("lastName") String lastName); 
	
}
