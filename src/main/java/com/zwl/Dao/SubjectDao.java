package com.zwl.Dao;

import java.util.Collection;

import com.zwl.Entity.Subject;

public interface SubjectDao {

	Collection<Subject> getAllSubjects();

	Subject getSubjectById(int subjectid);

	int removeSubjectById(int subjectid);

	void updateSubject(Subject subject);

	void insertSubjectToDb(Subject subject);

}