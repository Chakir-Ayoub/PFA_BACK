package com.example.demo.request;

import javax.validation.constraints.Size;

import jakarta.validation.constraints.*;

public class UserRequest {
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String firstName;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 3,message = "Ce champs doit avoir au moins 3 Caracteres !")
	private String lastName;
	@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Email(message = "Ce champs doit respecter la format email !")
	private String email;
	//@NotBlank(message = "Ce champs ne doit pas etre Null !")
	@Size(min = 8,message = "Ce champs doit avoir au moins 8 Caracteres !")
	@Size(max = 12,message = "Ce champs doit avoir au max 12 Caracteres !")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "Ce chmps doit avoid des lettres en Maj et Minsc et Numero ")
	private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
