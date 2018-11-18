package com.zwl.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zwl.Entity.Student;

@Repository("mysqlstudent")
public class MySqlStudentDaoImpl implements StudentDao{
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class StudentRowMapper implements RowMapper<Student>{
		
		@Override
		public Student mapRow(ResultSet resultSet,int i) throws SQLException{
		Student student=new Student();
		student.setId(resultSet.getInt("id"));
		student.setName(resultSet.getString("name"));
		student.setClassname(resultSet.getString("classname"));
		student.setStudentno(resultSet.getString("studentno"));
		return student;
	  }	
	
	}
	
	@Override
	public Collection<Student> getAllStudents() {
		//SELECT column_name(s) FROM table_name
		final String sql="SELECT id,name,classname,studentno FROM students";
	    List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper()); 
		return students;
	}
	

	@Override
	public Student getStudentByStudentno(String studentno) {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="SELECT id,name,classname,studentno FROM students where studentno=?";
		Student student=jdbcTemplate.queryForObject(sql, new StudentRowMapper(),studentno);
		return student;
	}
	
	@Override
	public int removeStudentById(int id) {
		//DELETE FROM table_name
		//WHERE some_column = some_value
		final String sql="DELETE FROM students WHERE id=?";
		int row;
		try {
		 row=jdbcTemplate.update(sql,id);
		}
		catch (DataIntegrityViolationException e) {
			row=-1;	
		}
		return row;
	}

	@Override
	public void updateStudent(Student student) {
		//UPDATE table_name
		//SET column1=value, column2=value2,...
		//WHERE some_column=some_value 
		final String sql="UPDATE students SET name=?,classname=?,studentno=? WHERE id=?";
		final int id=student.getId();
		final String name=student.getName();
		final String classname=student.getClassname();
		final String studentno=student.getStudentno();
		jdbcTemplate.update(sql,new Object[]{name,classname,studentno,id});
	}
	
	@Override
	public void insertStudentToDb(Student student) {
		//INSERT INTO table_name (column1, column2, column3,...)
		//VALUES (value1, value2, value3,...)
		final String sql="INSERT INTO students (name,classname,studentno) VALUES(?,?,?)";
		final String name=student.getName();
		final String classname=student.getClassname(); 
		final String studentno=student.getStudentno();
		jdbcTemplate.update(sql,new Object[]{name,classname,studentno});
	}
	
}
