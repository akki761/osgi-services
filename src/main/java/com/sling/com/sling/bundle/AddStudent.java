package com.sling.com.sling.bundle;

import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;
import org.osgi.service.component.annotations.Reference;

public class AddStudent implements Use{


	StudentService studentService;
	SlingHttpServletRequest request;
	List<String> students=null;
	boolean message=false;
	int age;
	String name;
	int id;
	int marks;


	@Override
	public void init(Bindings bindings) {
		request=(SlingHttpServletRequest) bindings.get("request");
		name= request.getParameter("name");
		age=Integer.parseInt(request.getParameter("age"));
		id=Integer.parseInt(request.getParameter("id"));
		marks=Integer.parseInt(request.getParameter("marks"));
		SlingScriptHelper slingScriptHelper=(SlingScriptHelper)bindings.get("sling");
		studentService=slingScriptHelper.getService(StudentService.class);

	}


	public List<String> getStudentList(){

		Student student=new Student(name, id, marks, age);
		message=studentService.addStudent(student);

		List<Student> list=new ArrayList<>();
		list=studentService.getStudentList();
		students=new ArrayList<>();

		if(message==false) {

			students.add("Full class");
			return students;
		}

		for(Student st:list)
			{
			System.out.println(st);
		    String s=st.getName();
		    System.out.println(s);
		    students.add(st.toString());

		}
		return students;

	}



	
}
