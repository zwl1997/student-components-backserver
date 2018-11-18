package com.zwl.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zwl.Dao.SubjectDao;
import com.zwl.Entity.Subject;

@Service
public class SubjectService {
	
	@Autowired
	@Qualifier("mysqlsubject")
	private SubjectDao subjectDao;
	
	public Collection<Subject> getAllSubjects(){
		
		return this.subjectDao.getAllSubjects();
	}
	
	public Subject getSubjectById(int subjectid) {
		return this.subjectDao.getSubjectById(subjectid);
	}
	
	public Integer removeSubjectById(int subjectid) {
		int status=this.subjectDao.removeSubjectById(subjectid);	
		return status;	
	}
	
	public void updateSubject(Subject subject) {
		this.subjectDao.updateSubject(subject);
	}
	
	public void insertSubject(Subject subject) {
		this.subjectDao.insertSubjectToDb(subject);
	}
}
