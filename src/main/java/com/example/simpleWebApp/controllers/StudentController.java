package com.example.simpleWebApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.dto.StudentRequestDTO;
import com.example.simpleWebApp.dto.StudentResponseDTO;
import com.example.simpleWebApp.model.Student;
import com.example.simpleWebApp.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/all")
	public List<StudentResponseDTO> getStudent() {

		return  studentservice.getStudentDetails();
	}
	
	@GetMapping("/{studId}")
	public StudentResponseDTO getStudentid(@PathVariable int studId) {

		return  studentservice.getStudentDetailsId(studId);
	}
	
	@PostMapping("/add")
	public void addStudentDetails(@RequestBody StudentRequestDTO s) {
		studentservice.addStudent(s);
	}
	
	@PutMapping("/update")
	public void updateStudentdata(@RequestBody StudentRequestDTO st) {
		studentservice.updateStudent(st);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudentdata(@PathVariable int id) {
		studentservice.deleteStudent(id);
	}
}
