package com.example.simpleWebApp.dto;

import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {
	
	@NotNull(message = "Id cannot be null")
	private int studId;
	@NotNull(message = "Name cannot be null")
	private String studName;
	@NotNull(message = "Email cannot be null")
	private String studEmail;
	@NotNull(message = "Password cannot be null")
	private String studPassword;
	@NotNull(message = "Contact Number cannot be null")
	private long studContact;
	
	public StudentRequestDTO() {} 


	public StudentRequestDTO(int studId, String studName, String studEmail,String studPassword,long studContact) {
		this.studId = studId;
		this.studContact=studContact;
		this.studName = studName;
		this.studEmail = studEmail;
		this.studPassword=studPassword;

	}
	public long getStudContact() {
		return studContact;
	}


	public void setStudContact(long studContact) {
		this.studContact = studContact;
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
	
	@Override
	public String toString() {
		return "StudentRequestDTO [studId=" + studId + ", studName=" + studName + ", studEmail=" + studEmail
				+ ", studPassword=" + studPassword + "]";
	}
	
}