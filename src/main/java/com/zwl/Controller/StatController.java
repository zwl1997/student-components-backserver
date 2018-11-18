package com.zwl.Controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zwl.Entity.Stat;
import com.zwl.Service.StatService;

@RestController
@RequestMapping("/stats")
public class StatController {
	
	@Autowired  
	private StatService statService;
/*
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return studentService.getAllStudents();
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}
	*/
	
	@RequestMapping(value="/high",method=RequestMethod.GET)
	public String getStatHigh() {
		return statService.getStatHigh();
	}
	
	@RequestMapping(value="/low",method=RequestMethod.GET)
	public String getStatLow() {
		return statService.getStatLow();
	}
	
	@RequestMapping(value="/avg",method=RequestMethod.GET)
	public String getStatAvg() {
		return statService.getStatAvg();
	}
	
	@RequestMapping(value="/levels",method=RequestMethod.GET)
	public Map<String,Integer> getStatLevels() {
		return statService.getStatLevels();
	}
}