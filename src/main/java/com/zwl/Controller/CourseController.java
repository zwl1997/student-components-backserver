package com.zwl.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.zwl.Entity.Course;
import com.zwl.Service.CourseService;

@RestController
//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired  
	private CourseService courseService;

	@RequestMapping(method=RequestMethod.GET)
	public Collection<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Course getCourseById(@PathVariable("id") int id) {
		return courseService.getCourseById(id);
	}

    @RequestMapping(value="/MaxId",method=RequestMethod.GET)
    public int getMaxId() {
        return courseService.getMaxId();
    }

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCourseById(@PathVariable("id") int id) {
		 if(courseService.removeCourseById(id)!=1) {
			 return ResponseEntity.noContent().build();  //204 no content
		 }
		 return ResponseEntity.ok().build();  //200 OK
	}
	

	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteCourseById(@RequestBody Course course) {
		courseService.updateCourse(course );
	}
	

	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertCourseById(@RequestBody Course course) {
		courseService.insertCourse(course);
	}
}