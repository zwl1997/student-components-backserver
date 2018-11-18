package com.zwl.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zwl.Entity.Course;


@Repository //("mysqlcourse")
public class MySqlCourseDaoImpl implements CourseDao{
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class CourseRowMapper implements RowMapper<Course>{
		
		@Override
		public Course mapRow(ResultSet resultSet,int i) throws SQLException{
		Course course=new Course();
		course.setId(resultSet.getInt("CourseID"));
		course.setName(resultSet.getString("name"));
		course.setTime(resultSet.getString("time"));
		course.setType(resultSet.getString("type"));
		return course;
	  }	
	
	}

	private static class MaxIdRowMapper implements RowMapper<Integer>{

		@Override
		public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
			return resultSet.getInt("maxId");
		}
	}
	
	@Override
	public Collection<Course> getAllCourses() {
		//SELECT column_name(s) FROM table_name
		final String sql="SELECT CourseID,name,time,type FROM course";
	    List<Course> courses = jdbcTemplate.query(sql, new CourseRowMapper()); 
		return courses;
	}
	

	@Override
	public Course getCourseById(int id) {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="SELECT CourseID,name,time,type FROM course where CourseID=?";
		Course course=jdbcTemplate.queryForObject(sql, new CourseRowMapper(),id);
		return course;
	}
	
	@Override
	public int removeCourseById(int id) {
		//DELETE FROM table_name
		//WHERE some_column = some_value
		final String sql="DELETE FROM course WHERE CourseID=?";
		
		int row=jdbcTemplate.update(sql,id);
		
		return row;
	}

	@Override
	public void updateCourse(Course course) {
		//UPDATE table_name
		//SET column1=value, column2=value2,...
		//WHERE some_column=some_value 
		final String sql="UPDATE course SET name=?,time=?,type=? WHERE CourseID=?";
		final int id=course.getId();
		final String name=course.getName();
		final String time=course.getTime(); 
		jdbcTemplate.update(sql,new Object[]{name,time,id});
	}
	
	@Override
	public void insertCourseToDb(Course course) {
		//INSERT INTO table_name (column1, column2, column3,...)
		//VALUES (value1, value2, value3,...)
		final String sql="INSERT INTO course (name,time,type) VALUES(?,?,?)";
		final String name=course.getName();
		final String time=course.getTime();
		final String type=course.getType();
		jdbcTemplate.update(sql,new Object[]{name,time,type});
	}

	@Override
	public int getMaxId() {

		final String sql = "SELECT MAX(CourseID) as maxId from course";
		int res = jdbcTemplate.queryForObject(sql, new MaxIdRowMapper());
		return res;
	}

}