package com.sm.service;

import java.util.List;

import com.sm.api.ChatData;
import com.sm.api.Student;
//service methods are same ad DAO methods
public interface StudentService {

	List<Student> loadStudents();
	void saveStudent(Student student);
	Student getStudent(int id);
	void update(Student student);
	void delete(int id);
	void deleteSelection(int[] ids);
	String getImageById(int ids);
	List<ChatData> groupStudentDataByCourse();
	List<ChatData> groupStudentDataByCountry();
	Student findByEmailAndPassword(String email, String password);
	Student getStudentByEmail(String email);
	void update1(Student student1);
	
    
}
