package com.zwl.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zwl.Dao.StudentDao;
import com.zwl.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("mysqlstudent")
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		
		return this.studentDao.getAllStudents();
	}
	
	public Student getStudentByStudentno(String studentno) {
		return this.studentDao.getStudentByStudentno(studentno);
	}
	
	public Integer removeStudentById(int id) {
		int status=this.studentDao.removeStudentById(id);	
		return status;
	}
	
	public void updateStudent(Student student) {
		this.studentDao.updateStudent(student);
	}
	
	public void insertStudent(Student student) {
		this.studentDao.insertStudentToDb(student);
	}
}
