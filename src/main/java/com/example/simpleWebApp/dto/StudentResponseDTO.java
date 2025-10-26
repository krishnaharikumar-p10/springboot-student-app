package com.example.simpleWebApp.dto;


public class StudentResponseDTO {
	

	private int studId;
	private String studName;
	private String studEmail;
	
	public StudentResponseDTO() {} 


	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}


	public StudentResponseDTO(int studId, String studName, String studEmail) {
		this.studName = studName;
		this.studEmail = studEmail;
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