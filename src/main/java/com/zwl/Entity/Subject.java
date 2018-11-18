package com.zwl.Entity;

public class Subject {
	private int subjectid;
	private String studentid;
	private String classname;
	private String studentname;
	private String coursename;
	private String subjectfinal;
	
	public Subject (int subjectid,String studentid,String classname,String coursename,String subjectfinal,String studentname) {
		this.subjectid=subjectid;
		this.studentid=studentid;
		this.coursename=coursename;
		this.subjectfinal=subjectfinal;
		this.studentname=studentname;
		this.classname=classname;
	}
	
 	public Subject (){}
 	
 	public int getSubjectid() {
 		return subjectid;
 	}
 	
 	public void setSubjectid(int subjectid) {
 		this.subjectid=subjectid;
 	}
 	
 	public String getStudentid() {
 		return studentid;
 	}
 	
 	public void setStudentid(String studentid) {
 		this.studentid=studentid;
 	}
 	
 	public String getCoursename() {
 		return coursename;
 	}
 	
 	public void setCoursename(String coursename) {
 		this.coursename=coursename;
 	}
 	
 	public String getSubjectfinal() {
 		return subjectfinal;
 	}
 	
 	public void setSubjectfinal(String subjectfinal) {
 		this.subjectfinal=subjectfinal;
 	}
 	
 	public String getStudentname() {
 		return studentname;
 	}
 	
 	public void setStudentname(String studentname) {
 		this.studentname=studentname;
 	}
 	
 	public String getClassname() {
 		return classname;
 	}
 	
 	public void setClassname(String classname) {
 		this.classname=classname;
 	}
}