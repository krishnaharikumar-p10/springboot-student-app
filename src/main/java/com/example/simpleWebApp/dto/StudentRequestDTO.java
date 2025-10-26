package com.example.simpleWebApp.dto;


public class StudentRequestDTO {
	

	private int studId;
	private String studName;
	private String studEmail;
	private String studPassword;
	
	public StudentRequestDTO() {} 


	public StudentRequestDTO(int studId, String studName, String studEmail,String studPassword) {
		this.studName = studName;
		this.studEmail = studEmail;
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