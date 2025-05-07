package com.home.sabir.springboot.SpringDataJPA.service;

import java.util.List;

import com.home.sabir.springboot.SpringDataJPA.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	List<Student> getStudentByName(String name);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student, Long id);
	
	void deleteStudentById(Long id);
}
