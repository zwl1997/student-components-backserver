package com.zwl.Entity;

public class Student {
	private int id;
	private String name;
	private String classname;
	private String studentno;
	
	public Student(int id,String name,String classname,String studentno) {
		this.id=id;
		this.name=name;
		this.classname=classname;
		this.studentno=studentno;
	}
	
 	public Student(){}
 	
 	public int getId() {
 		return id;
 	}
 	
 	public void setId(int id) {
 		this.id=id;
 	}
 	
 	public String getName() {
 		return name;
 	}
 	
 	public void setName(String name) {
 		this.name=name;
 	}
 	
 	public String getClassname() {
 		return classname;
 	}
 	
 	public void setClassname(String classname) {
 		this.classname=classname;
 	}
 	
 	public String getStudentno() {
 		return studentno;
 	}
 	
 	public void setStudentno(String studentno) {
 		this.studentno=studentno;
 	}
}