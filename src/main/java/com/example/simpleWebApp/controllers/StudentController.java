package com.example.simpleWebApp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.example.simpleWebApp.model.Academic;
import com.example.simpleWebApp.model.Student;
import com.example.simpleWebApp.service.StudentService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	
	@GetMapping("/all")
	public List<StudentResponseDTO> getStudentDetails() {

		return  studentservice.getStudentDetails();
	}
	
	
	@GetMapping("/{studId}")
	public StudentResponseDTO getStudentDetailsId(@PathVariable int studId) {

		return  studentservice.getStudentDetailsId(studId);
	}
	
	
	@PostMapping("/add")
	public void  addStudentDetails(@Valid @RequestBody StudentRequestDTO s) {
		studentservice.addStudent(s);
	}
	
	
	@PutMapping("/update")
	public void updateStudentdata(@Valid @RequestBody StudentRequestDTO st) {
		studentservice.updateStudent(st);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudentdata(@PathVariable int id) {
		studentservice.deleteStudent(id);
	}
	
	//////////////External API Call using WebClient/////////////
	
	
    @GetMapping("/academic/{id}")
    public Academic getAcademicDetails(@PathVariable int id) {
        return studentservice.getAcademicByStudentId(id);
        
    }
    
    @PostMapping("/academic/add")
    public void addAcademicDetails(@RequestBody Academic acd){
    	studentservice.addAcademicDetails( acd);
    	
    }
    
    @PutMapping("/academic/update")
    public void updateAcademicDetails(@RequestBody Academic acd ) {
    	studentservice.updateAcademicDetails(acd);
    }
    
    @DeleteMapping("/academic/delete/{id}")
    public void deleteAcademicDetails(@PathVariable int id) {
    	studentservice.deleteAcademicDetails(id);
    }
    
    @GetMapping("/academic/overallcgpa")
    public double overallCGPA() {
    	return studentservice.overallCGPA();
    }

}
