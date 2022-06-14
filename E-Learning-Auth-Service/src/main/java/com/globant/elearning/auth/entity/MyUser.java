package com.globant.elearning.auth.entity;

import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Size(min = 4, max = 30, message = "minimum length 3 digits")
	@NotNull
	@NotEmpty
	private String userName;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(?=(.*[0-9]){1,})(?=(.*[a-z]){1,})(?=(.*[A-Z]){1,})(?=(.*[^0-9a-zA-Z]){1,})(?=\\S+$).{8,}$", message = "A minimum 8 characters password contains a combination of uppercase and lowercase letter and number are required")
	private String password;

	@NotNull
	@NotEmpty
	private String matchingPassword; 

	@Size(min = 4, max = 64, message = "minimum length 3 digits")
	@NotNull
	@NotEmpty
	private String firstName;

	@Size(min = 4, max = 64, message = "minimum length 3 digits")
	@NotNull
	@NotEmpty
	private String lastName;

	@Size(min = 4, max = 30, message = "minimum length 3 digits")
	@NotNull
	@NotEmpty
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}") 
	private String email;

	private boolean active;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Role> role;

	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyUser(Integer id, String userName, String password, String matchingPassword, String firstName,
			String lastName, String email, boolean active, Set<Role> role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

		this.active = active;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
