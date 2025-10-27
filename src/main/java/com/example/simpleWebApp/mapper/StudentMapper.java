package com.example.simpleWebApp.mapper;

import org.springframework.stereotype.Component;

import com.example.simpleWebApp.dto.StudentRequestDTO;
import com.example.simpleWebApp.dto.StudentResponseDTO;
import com.example.simpleWebApp.model.Student;

@Component
public class StudentMapper {
	
	public StudentResponseDTO toDTO(Student s){
		
		StudentResponseDTO dto= new StudentResponseDTO();
		dto.setStudId(s.getStudId());
		dto.setStudName(s.getStudName());
		dto.setStudEmail(s.getStudEmail());
		return dto;
	}
	public Student toEntity(StudentRequestDTO s) {
		
		Student student = new Student();
		
		student.setStudName(s.getStudName());
		student.setStudEmail(s.getStudEmail());
		student.setStudPassword(s.getStudPassword());
		
		return student;
		
	}
	
	public Student updateEntityfromDTO (StudentRequestDTO s,Student stud) {
		
		stud.setStudName(s.getStudName());
		stud.setStudEmail(s.getStudEmail());
		stud.setStudPassword(s.getStudPassword());
		return stud;
		
		
	}
}
