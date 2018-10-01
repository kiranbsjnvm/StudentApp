package com.studentApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentApi.models.Student;
import com.studentApi.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAll(List<Integer> classes,String isActive,String afterYear,String beforeYear){
		
		if(classes.size() == 0 && isActive.isEmpty() && afterYear.isEmpty() && beforeYear.isEmpty()){
			return (List<Student>) studentRepository.findAll();
		}
		
		else if(isActive.isEmpty() && afterYear.isEmpty() && beforeYear.isEmpty()){
			return studentRepository.findByStudentClassIn(classes);
		}
		
		else if(afterYear.isEmpty() && beforeYear.isEmpty()){
			boolean studentActive = Boolean.parseBoolean(isActive);  
			return studentRepository.findByStudentClassInAndStudentActive(classes, studentActive);
		}
		
		else if(classes.size() != 0 && !isActive.isEmpty() && !afterYear.isEmpty()){
			boolean studentActive = Boolean.parseBoolean(isActive);
			Long afterYear1 = Long.parseLong(afterYear);
			return studentRepository.findByStudentClassInAndStudentActiveAndAdmissionYearGreaterThan(classes, studentActive,afterYear1);
		}
		
		else if(classes.size() != 0 && !isActive.isEmpty() && !beforeYear.isEmpty()){
			boolean studentActive = Boolean.parseBoolean(isActive);  
			Long beforeYear1 = Long.parseLong(beforeYear);
			return studentRepository.findByStudentClassInAndStudentActiveAndAdmissionYearLessThan(classes, studentActive,beforeYear1);
		}
		
		else{
			return null;
		}
		
	}
	
	public Student getStudent(int id) {
		if(studentRepository.existsById(id)){
			return studentRepository.findById(id).get();
		}else{
			return null;
		}
		
	}
	
	public boolean addStudent(Student student){
		if(student.getStudentName() != null && student.getClass() != null && student.getAdmissionYear() !=null ){
			student.setStudentActive(true);
			studentRepository.save(student);
			return true;
		}
		return false;
		
	}

	public void updateStudent(Student student,int id) {
		if(studentRepository.existsById(id)){
			Student existingStudent = studentRepository.findById(id).get();
			existingStudent.setStudentClass(student.getStudentClass());
			studentRepository.save(existingStudent);
		}
		
	}

	public void deleteStudent(int id) {
		if(studentRepository.existsById(id)){
			Student student = studentRepository.findById(id).get();
			student.setStudentActive(false);
			studentRepository.save(student);
		}
	}
}
