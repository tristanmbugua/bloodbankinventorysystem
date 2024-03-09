package com.spring.jpa;

import jakarta.persistence.Column;
import java.sql.*;
import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@Column(name="phone")
	private long phone;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="dateofbirth")
	private Date dateOfBirth;
	@Column(name="gender")
	private String gender;
	@Column(name="bloodgroup")
	private int bloodGroup;
	@Column(name="city")
	private String city;
	
	public Patient(
			long phone,String firstName,
			String lastName,Date dateOfBirth,
			String gender, int bloodGroup,
			String city) {	
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.city = city;
	}
	
	public Patient() {	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getPhone() {
		return this.phone;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return this.lastName;
	}
	
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return this.gender;
	}

	public void setBloodGroup(int bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getBloodGroup() {
		return this.bloodGroup;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return this.city;
	}
}
