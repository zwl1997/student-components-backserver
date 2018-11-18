package com.zwl.Dao;

import java.util.Collection;

import com.zwl.Entity.Course;

public interface CourseDao {

	Collection<Course> getAllCourses();

	Course getCourseById(int id);

	int removeCourseById(int id);

	void updateCourse(Course course);

	void insertCourseToDb(Course course);

	int getMaxId();

}