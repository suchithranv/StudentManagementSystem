package com.sm.dao;

import java.util.List;

import com.sm.api.ChatData;
import com.sm.api.Student;

public interface StudentDAO {
	
	//get all students
	List<Student> loadStudents();

	//save student
	void saveStudent(Student student);
	
	//get student by id
	Student getStudent(int id);
	
	//update student
	void update(Student student);
	
	//delete student
	void delete(int id);
    
	//delete selected students
	void deleteSelection(int[] ids);
    
    // get student image by id
	String getImageById(int ids);

	//group student by course
	List<ChatData> groupStudentDataByCourse();

	//group student by country
	List<ChatData> groupStudentDataByCountry();

	Student findByEmailAndPassword(String email, String password);
	
	Student getStudentByEmail(String email);

	void update1(Student student1);


}
