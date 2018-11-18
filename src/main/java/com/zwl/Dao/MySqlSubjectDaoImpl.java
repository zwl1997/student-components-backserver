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

import com.zwl.Entity.Subject;

@Repository("mysqlsubject")
public class MySqlSubjectDaoImpl implements SubjectDao{
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class SubjectRowMapper implements RowMapper<Subject>{
		
		@Override
		public Subject mapRow(ResultSet resultSet,int i) throws SQLException{
		Subject subject=new Subject();
		subject.setSubjectid(resultSet.getInt("subjectid"));
		subject.setStudentname(resultSet.getString("studentname"));
		subject.setCoursename(resultSet.getString("coursename"));
		subject.setSubjectfinal(resultSet.getString("subjectfinal"));
		subject.setStudentid(resultSet.getString("studentid"));
		subject.setClassname(resultSet.getString("classname"));
		return subject;
	  }	
	
	}
	
	@Override
	public Collection<Subject> getAllSubjects() {
		//SELECT column_name(s) FROM table_name
		final String sql="SELECT a.subjectid,b.classname,a.studentid,b.name as studentname,a.coursename,a.subjectfinal FROM subject a, students b where a.studentid=b.id";
	    List<Subject> subject = jdbcTemplate.query(sql, new SubjectRowMapper()); 
		return subject;
	}
	

	@Override
	public Subject getSubjectById(int subjectid) {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="SELECT subjectid,studentid,coursename,subjectfinal FROM subject where subjectid=?";
		Subject subject=jdbcTemplate.queryForObject(sql, new SubjectRowMapper(),subjectid);
		return subject;
	}
	
	@Override
	public int removeSubjectById(int subjectid) {
		//DELETE FROM table_name
		//WHERE some_column = some_value
		final String sql="DELETE FROM subject WHERE subjectid=?";
		int row;
		try {
		 row=jdbcTemplate.update(sql,subjectid);
		}
		catch (DataIntegrityViolationException e) {
			row=-1;	
		}
		return row;
	}

	@Override
	public void updateSubject(Subject subject) {
		//UPDATE table_name
		//SET column1=value, column2=value2,...
		//WHERE some_column=some_value 
		final String sql="UPDATE subject SET studentid=?,coursename=?,subjectfinal=? WHERE subjectid=?";
		final int subjectid=subject.getSubjectid();
		final String studentid=subject.getStudentid();
		final String coursename=subject.getCoursename();
		final String subjectfinal=subject.getSubjectfinal();
		jdbcTemplate.update(sql,new Object[]{studentid,coursename,subjectfinal,subjectid});
	}
	
	@Override
	public void insertSubjectToDb(Subject subject) {
		//INSERT INTO table_name (column1, column2, column3,...)
		//VALUES (value1, value2, value3,...)
		final String sql="INSERT INTO subject (studentid,coursename,subjectfinal) VALUES(?,?,?)";
		final String studentid=subject.getStudentid();
		final String coursename=subject.getCoursename(); 
		final String subjectfinal=subject.getSubjectfinal();
		jdbcTemplate.update(sql,new Object[]{studentid,coursename,subjectfinal});
	}
	
}