package com.zwl.Dao;

import java.util.Collection;

import com.zwl.Entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentByStudentno(String studentno);

	int removeStudentById(int id);

	void updateStudent(Student student);

	void insertStudentToDb(Student student);

}