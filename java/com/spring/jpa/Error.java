package com.spring.jpa;

import jakarta.persistence.*;

@Entity 
@Table(name ="Error")
public class Error {
	@Id
	@Column(name="errorType")
	private String errorType;
	@Column(name="errorLocation")
	private String errorLocation;
	@Column(name="message")
	private String message;
	
	public Error() { }
	
	public Error(
			String errorType,
			String errorLocation,
			String message
		) {
		this.errorLocation = errorLocation;
		this.errorType = errorType;
		this.message = message;
	}
	
	
	public String getErrorLocation() {
		return this.errorLocation;
	}
	
	public void setErrorLocation(String errorLocation) {
		this.errorLocation = errorLocation;
	}
	
	
	public String getErrorType() {
		return this.errorType;
	}
	
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
