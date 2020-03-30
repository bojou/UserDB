package io.halfnhalf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//gasgasga

@ComponentScan
@SpringBootApplication
public class UserDatabaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDatabaseApiApplication.class, args);
	}

}
