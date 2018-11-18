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

import com.zwl.Entity.Student;
import com.zwl.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired  
	private StudentService studentService;

	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	/*
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}
	*/
	
	@RequestMapping(value="/{studentno}",method=RequestMethod.GET)
	public Student getStudentByName(@PathVariable("studentno") String studentno) {
		return studentService.getStudentByStudentno(studentno);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudentById(@PathVariable("id") int id) {
		
		 if(studentService.removeStudentById(id)!=1) {
			 return ResponseEntity.noContent().build();
		 }
		 return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudentById(@RequestBody Student student) {
		studentService.updateStudent(student );
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertStudentById(@RequestBody Student student) {
		studentService.insertStudent(student);
	}
}
