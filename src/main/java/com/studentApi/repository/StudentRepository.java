package com.studentApi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.studentApi.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	List<Student> findAll(Pageable pageRequest);
	List<Student> findByStudentClassIn(List<Integer> studentClass,Pageable pageRequest);
	List<Student> findByStudentClassInAndStudentActive(List<Integer> studentClass,boolean studentActive,Pageable pageRequest);
	List<Student> findByStudentClassInAndStudentActiveAndAdmissionYearGreaterThan(List<Integer> studentClass,boolean studentActive,Long afterYear,Pageable pageRequest);
	List<Student> findByStudentClassInAndStudentActiveAndAdmissionYearLessThan(List<Integer> studentClass,boolean studentActive,Long beforeYear,Pageable pageRequest);
}
