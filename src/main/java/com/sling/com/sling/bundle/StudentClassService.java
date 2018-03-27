package com.sling.com.sling.bundle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service=StudentService.class, immediate=true)
public class StudentClassService implements StudentService {
	
	
	ArrayList<Student> al=new ArrayList<>();
	
	@Reference
	ClassService classService;
	
	
	@Override    
	public boolean addStudent(Student student) {
	   if(classService.isClassLimitReached(al)) {
		   System.out.println("Student Limit reached");
		   return false;
	   }
	   else
	   {
		   al.add(student);
		   System.out.println("Student added successfully");
		   return true;
	   }
	}
	
	@Override
	public void deleteStudent(int id) {
	   Iterator<Student> itr=al.iterator();
	   int f=0;
	   while(itr.hasNext()) {
		   Student s=(Student)itr.next();
		   if(id == s.getId()) {
			   al.remove(s);
		    System.out.println("Element removed successfully");
		      f=0;
		      break;
		   }	
	   }
	   if(f==1)
		   System.out.println("Element not found");
	   
	}
	
	@Override
	public boolean isStudentPassed(int id) {
		
		Iterator itr=al.iterator();
		boolean flag=false;
		while(itr.hasNext()) {
			Student s=(Student)itr.next();
			if(id == s.getId()) {
				if(s.getMarks()>=classService.getPassingMarks())
					flag=true;
				}
		}
	  return flag;
	}
	
	@Override
	public Student getStudent(int id) {
		Iterator itr=al.iterator();
		Student stu= null;
		while(itr.hasNext()) {
			Student s=(Student)itr.next();
			if(id == s.getId()) {
				stu= s;
			}
		}
		return stu;
	
	}
	
	
	@Override
	public List getStudentList() {
		return al;
	}
	
	@Activate
	public void activate() {
		System.out.println("This is in activate function");
//		Student s= new Student();
//		s.setAge(20);
//		s.setId(01);
//		s.setMarks(89);
//		s.setName("Akash");
//		
//		Student s1=new Student();
//		s1.setAge(21);
//		s1.setId(02);
//		s1.setMarks(92);
//		s1.setName("Vaibhav");
	}
}
