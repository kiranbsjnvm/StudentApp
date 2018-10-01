package com.studentApi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentApi.models.Student;
import com.studentApi.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	
	@RequestMapping("/students")
	public List<Student> getAll(@RequestParam(value="classes", defaultValue="") List<Integer> studClasses,
								@RequestParam(value="active", defaultValue="") String isActive,
								@RequestParam(value="admissionYearAfter", defaultValue="") String afterYear,
								@RequestParam(value="admissionYearBefore", defaultValue="") String beforeYear){
		
			return studentService.getAll(studClasses,isActive,afterYear,beforeYear);
		
	}
	
	
	@RequestMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId){
		
		Student student = studentService.getStudent(studentId);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/students")
	public ResponseEntity<Boolean> addStudent(@RequestBody Student student){
		
		if(studentService.addStudent(student)){
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value = "/students/{id}")
	public void updateStudent(@RequestBody Student student,@PathVariable int id){
		studentService.updateStudent(student,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/students/{id}")
	public void deleteStudent(@PathVariable int id){
		studentService.deleteStudent(id);
	}
}
