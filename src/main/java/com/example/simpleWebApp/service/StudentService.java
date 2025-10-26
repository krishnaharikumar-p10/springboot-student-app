package com.example.simpleWebApp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simpleWebApp.dto.StudentRequestDTO;
import com.example.simpleWebApp.dto.StudentResponseDTO;
import com.example.simpleWebApp.mapper.StudentMapper;
import com.example.simpleWebApp.model.Student;
import com.example.simpleWebApp.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	@Autowired
	StudentMapper mapper;
	
	public List<StudentResponseDTO> getStudentDetails(){
		
		List<Student> student = repo.findAll();
		List<StudentResponseDTO> dtolist = new ArrayList<>();
		for( Student s: student) {
			dtolist.add(mapper.toDTO(s));
		}
		return dtolist;
	
	}
	
	public StudentResponseDTO getStudentDetailsId(int studId) {

		Student student = repo.findById(studId).orElse(new Student());
		return mapper.toDTO(student);
	}

	public void addStudent(StudentRequestDTO s) {

		Student student = mapper.toEntity(s);
		repo.save(student);
		
	}
	
	public void updateStudent(StudentRequestDTO st) {
		
		Student student= mapper.toEntity(st);
		repo.save(student);
	}

	public void deleteStudent(int id) {
		
		repo.deleteById(id);
		
	}

	
	
}	
