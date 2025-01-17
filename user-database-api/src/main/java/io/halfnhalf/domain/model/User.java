package io.halfnhalf.domain.model;

import javax.persistence.Column;

/**
 * Class used to model database entries as POJO's
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	
	/**
	 * ID, only non-encrypyted value-
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", 
	strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	/**
	 * @ColumnTransformer specifies how columns are to be read and written to respectively
	 */
	@ColumnTransformer(forColumn = "first_name", 
			read = "pgp_sym_decrypt(first_name::bytea, 'AC10G31VX9330XP0')",
			write = "pgp_sym_encrypt(?, 'AC10G31VX9330XP0')")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	
	@ColumnTransformer(forColumn = "last_name", 
			read = "pgp_sym_decrypt(last_name::bytea, 'AC10G31VX9330XP0')",
			write = "pgp_sym_encrypt(?, 'AC10G31VX9330XP0')")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@ColumnTransformer(forColumn = "age", 
			read = "pgp_sym_decrypt(age::bytea, 'AC10G31VX9330XP0')",
			write = "pgp_sym_encrypt(?::text, 'AC10G31VX9330XP0')")
	@Column(name = "age", nullable = false)
	private int age;
	
	

	public User() {
		
	}
	
	public User(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}