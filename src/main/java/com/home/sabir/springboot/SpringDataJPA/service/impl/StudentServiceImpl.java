package com.home.sabir.springboot.SpringDataJPA.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.sabir.springboot.SpringDataJPA.entity.Student;
import com.home.sabir.springboot.SpringDataJPA.exception.ResourceNotFoundException;
import com.home.sabir.springboot.SpringDataJPA.repository.StudentRepository;
import com.home.sabir.springboot.SpringDataJPA.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	
	@Override
	public Student getStudentById(Long id) {
//		Optional<Student> student = studentRepository.findById(id);
//		if(student.isPresent()) {
//			return student.get();
//		}else {
//			throw new ResourceNotFoundException("Student", "Id", id);
//		}
		return studentRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Student", "Id", id));
		
	}
	
	@Override
	public List<Student> getStudentByName(String name) {
//		Optional<Student> student = studentRepository.findById(id);
//		if(student.isPresent()) {
//			return student.get();
//		}else {
//			throw new ResourceNotFoundException("Student", "Id", id);
//		}
		return studentRepository.findByFirstName(name);
		
	}

	
	@Override
	public Student updateStudent(Student student, Long id) {
		
		// we need to check whether student with given id is exist in DB or not
		Student existingStudent = studentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", id)); 
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		// save existing student to DB
		studentRepository.save(existingStudent);
		return existingStudent;
	}
	

	@Override
	public void deleteStudentById(Long id) {		
		// check whether a student exist in a DB or not
		studentRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);
	}
	

}
