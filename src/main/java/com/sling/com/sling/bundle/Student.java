package com.sling.com.sling.bundle;

public class Student {
  
  private String name;
  private int id;
  private int marks;
  private int age;
  
  
  
  
public Student(String name, int id, int marks, int age) {
	super();
	this.name = name;
	this.id = id;
	this.marks = marks;
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Student [name=" + name + ", id=" + id + ", marks=" + marks + ", age=" + age + "]";
}
  
  
}
