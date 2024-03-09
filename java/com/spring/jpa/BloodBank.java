package com.spring.jpa;

import jakarta.persistence.*;

@Entity
@Table(name="bloodbank")
public class BloodBank {
	@Id
	@Column(name="phone")
	private long phone;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="website")
	private String website;
	@Column(name="email")
	private String email;
	
	public BloodBank(
			long phone, String name,
			String address, String city,
			String website,String email) {	
		this.phone = phone;
		this.name = name;
		this.address = address;
		this.city = city;
		this.website = website;
		this.email = email;
	}
	
	public BloodBank() {	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return this.city;
	}
	

	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getPhone() {
		return this.phone;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getWebsite() {
		return this.website;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
}
