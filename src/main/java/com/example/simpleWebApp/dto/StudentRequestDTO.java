package com.example.simpleWebApp.dto;

import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {
	

	private int studId;
	@NotNull(message = "Name cannot be null")
	private String studName;
	@NotNull(message = "Email cannot be null")
	private String studEmail;
	@NotNull(message = "Password cannot be null")
	private String studPassword;
	
	public StudentRequestDTO() {} 


	public StudentRequestDTO(int studId, String studName, String studEmail,String studPassword) {
		this.studId = studId;          
	    this.studName = studName;
	    this.studEmail = studEmail;
	    this.studPassword = studPassword; 

	}
	

	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudPassword() {
		return studPassword;
	}


	public void setStudPassword(String studPassword) {
		this.studPassword = studPassword;
	}


	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudEmail() {
		return studEmail;
	}

	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}
	
}