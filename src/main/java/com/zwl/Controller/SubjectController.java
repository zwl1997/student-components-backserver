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

import com.zwl.Entity.Subject;
import com.zwl.Service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	@Autowired  
	private SubjectService subjectService;

	@RequestMapping(method=RequestMethod.GET)
	public Collection<Subject> getAllSubjects(){
		return subjectService.getAllSubjects();
	}
	
	@RequestMapping(value="/{subjectid}",method=RequestMethod.GET)
	public ResponseEntity<Object> getSubjectById(@PathVariable("subjectid") int subjectid) {
		 
		if(subjectService.removeSubjectById(subjectid)!=1) {
			 return ResponseEntity.noContent().build();
		 }
		 return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/{subjectid}",method=RequestMethod.DELETE)
	public void deleteSubjectById(@PathVariable("subjectid") int subjectid) {
		subjectService.removeSubjectById(subjectid);
	}
	
	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteSubejectById(@RequestBody Subject subject) {
		subjectService.updateSubject(subject);
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertSubjectById(@RequestBody Subject subject) {
		subjectService.insertSubject(subject);
	}
}
