package com.laundrovalley.rest.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public class User {
	
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String email;
	
	@Transient
	private String password;
	
	
	@Column(name="pass_hash")
	private String passHash;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassHash() {
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	
	
}
