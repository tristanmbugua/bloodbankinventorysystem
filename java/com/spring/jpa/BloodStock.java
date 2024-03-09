package com.spring.jpa;

import jakarta.persistence.Column;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name="bloodstock")
public class BloodStock {
	@Id
	@Column(name="bloodgroup")
	private int bloodGroup;
	@Column(name="quantity")
	private int quantity;
	@Column(name="bestbefore")
	private Date bestBefore;
	@Column(name="status")
	private String status;
	
	public BloodStock(
			int bloodGroup, int quantity,
			Date bestBefore,String status
			) {
		this.bloodGroup = bloodGroup;
		this.quantity = quantity;
		this.bestBefore = bestBefore;
		this.status = status;
	}
	
	public BloodStock() { }
	
	
	public void setBloodGroup(int bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getBloodGroup() {
		return this.bloodGroup;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	
	public void setBestBefore(Date bestBefore) {
		this.bestBefore = bestBefore;
	}
	public Date getBestBefore() {
		return this.bestBefore;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}
}
