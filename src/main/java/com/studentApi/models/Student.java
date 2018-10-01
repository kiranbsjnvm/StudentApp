package com.studentApi.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String studentName;
	private int studentClass;
	private boolean studentActive;
	private Long admissionYear;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public boolean isStudentActive() {
		return studentActive;
	}
	public void setStudentActive(boolean studentActive) {
		this.studentActive = studentActive;
	}
	public Long getAdmissionYear() {
		return admissionYear;
	}
	public void setAdmissionYear(Long admissionYear) {
		this.admissionYear = admissionYear;
	}
	
	
	
}
