package com.sling.com.sling.bundle;

import java.util.List;

public interface StudentService {
	
	boolean addStudent(Student values);
	
	void deleteStudent(int id);
	
	boolean isStudentPassed(int id);
	
	Student getStudent(int id);
	
	public List getStudentList();


}
