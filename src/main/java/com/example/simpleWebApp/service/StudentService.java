package com.example.simpleWebApp.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.simpleWebApp.dto.StudentRequestDTO;
import com.example.simpleWebApp.dto.StudentResponseDTO;
import com.example.simpleWebApp.exception.StudentNotFoundException;
import com.example.simpleWebApp.mapper.StudentMapper;
import com.example.simpleWebApp.model.Academic;
import com.example.simpleWebApp.model.Student;
import com.example.simpleWebApp.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	@Autowired
	StudentMapper mapper;
	
	@Autowired
	WebClient webClient;
	
	
	public List<StudentResponseDTO> getStudentDetails(){
	    List<Student> students = repo.findAll();
	    if (students.isEmpty()) {
	        throw new StudentNotFoundException("No students found");
	    }
		List<Student> student = repo.findAll();
		List<StudentResponseDTO> dtolist = new ArrayList<>();
		for( Student s: student) {
			dtolist.add(mapper.toDTO(s));
		}
		return dtolist;
	
	}
	
	public StudentResponseDTO getStudentDetailsId(int studId) {

		Student student = repo.findById(studId)
				.orElseThrow(() -> new StudentNotFoundException("Student with id " + studId + " not found"));
		return mapper.toDTO(student);
	}

	public void addStudent(StudentRequestDTO s) {

		Student student = mapper.toEntity(s);
		repo.save(student);
		
	}
	
	public void updateStudent(StudentRequestDTO st) {
		
		System.out.println(st);
		Student existingstudent= repo.findById(st.getStudId()).orElseThrow(() -> new StudentNotFoundException("Student with id " + st.getStudId() + " not found"));
	
		Student student= mapper.updateEntityfromDTO(st,existingstudent);
		repo.save(student);
	}

	public void deleteStudent(int id) {
	    if (!repo.existsById(id)) {
		        throw new StudentNotFoundException("Cannot delete — student with id " + id + " not found");
		    }
		repo.deleteById(id);
		
	}
	
	
	/////////////////////////////////////////////////
	
	
	
	public Academic getAcademicByStudentId(int studentId) {
        return webClient.get()
        		.uri("http://localhost:8082/academic/" + studentId)
                .retrieve()
                .bodyToMono(Academic.class)
                .block();
    }

	public void addAcademicDetails(Academic acd) {
		
				webClient.post()
				.uri("http://localhost:8082/academic/add")
				.bodyValue(acd)
				.retrieve()
				.toBodilessEntity()
				.block();
		
	}

	public void updateAcademicDetails(Academic acd) {
		
				webClient.put()
				.uri("http://localhost:8082/academic/update")
				.bodyValue(acd)
				.retrieve()
				.toBodilessEntity()
				.block();
	}

	public void deleteAcademicDetails(int id) {
		
				webClient.delete()
				.uri("http://localhost:8082/academic/delete/" + id)
				.retrieve()
				.toBodilessEntity()
				.block();		 
	}

	public double  overallCGPA() {
		
				List<Academic> acd=webClient.get()
				.uri("http://localhost:8082/academic/getall")
				.retrieve()
				.bodyToFlux(Academic.class)
				.collectList()
				.block();
		
				System.out.println(acd);
		
				double totalCgpa = acd.stream()
			    .map(a -> a.getCgpa())
			    .reduce(0.0, (a, b) -> a + b);

				double overallCgpa = totalCgpa / acd.size();
				return overallCgpa;

		
	}

	
	

	

	
	
}	
