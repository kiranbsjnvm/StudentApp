package com.studentApi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.studentApi.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	List<Student> findByStudentClassIn(List<Integer> studentClass);
	List<Student> findByStudentClassInAndStudentActive(List<Integer> studentClass,boolean studentActive);
	List<Student> findByStudentClassInAndStudentActiveAndAdmissionYearGreaterThan(List<Integer> studentClass,boolean studentActive,Long afterYear);
	List<Student> findByStudentClassInAndStudentActiveAndAdmissionYearLessThan(List<Integer> studentClass,boolean studentActive,Long beforeYear);
}
