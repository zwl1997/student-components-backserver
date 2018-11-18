package com.zwl.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zwl.Dao.CourseDao;
import com.zwl.Entity.Course;

@Component
//@Service
public class CourseService {
	
	@Autowired
	//@Qualifier  ("mysqlcourse")
	private CourseDao courseDao;
	
	public Collection<Course> getAllCourses(){
		return this.courseDao.getAllCourses();
	}
	
	public Course getCourseById(int id) {
		return this.courseDao.getCourseById(id);
	}
	
	public Integer removeCourseById(int id) {
		int status = this.courseDao.removeCourseById(id);	
		return status;
	}
	
	public void updateCourse(Course course) {
		this.courseDao.updateCourse(course);
	}
	
	public void insertCourse(Course course) {
		this.courseDao.insertCourseToDb(course);
	}

	public int getMaxId(){
		return this.courseDao.getMaxId();
	}
}
