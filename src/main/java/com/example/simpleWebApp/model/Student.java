package com.example.simpleWebApp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;
	
	private String studName;
	private String studEmail;
	private String studPassword;


	public Student() {} 

	
	public Student(int studId, String studName, String studEmail,String studPassword) {
		this.studId = studId;
		this.studName = studName;
		this.studEmail = studEmail;
		this.studPassword=studPassword;
	}
	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudPasswordd() {
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
	
	public String toString() {
		return studPassword;
		
	}
	
}
