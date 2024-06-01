package com.sm.service;
// this service layer will talk with DAO layer
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.api.ChatData;
import com.sm.api.Student;
import com.sm.controllers.StudentController;
import com.sm.dao.StudentDAO;

@Service   //since it is service class use this instead of @Component 
// used to annotate service layer implementation classes
public class StudentServiceImpl implements StudentService {
    
	private static final Logger log = LogManager.getLogger(StudentController.class.getName());
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Student> loadStudents() {
		log.debug("------------------ calling loadStudents() method of StudentDAO class");
		List<Student> studentList = studentDAO.loadStudents();   
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		
		log.debug("------------------------ calling saveStudent() method of StudentDAO class");
		studentDAO.saveStudent(student);
		
	}

	@Override
	public Student getStudent(int id) {
		
		log.debug("------------------------ calling getStudent() method of StudentDAO class");
		return studentDAO.getStudent(id);  //here we are making dao call
	}

	@Override
	public void update(Student student) {
		log.debug("------------------------ calling update() method of StudentDAO class");
		studentDAO.update(student);
	}

	@Override
	@Transactional
	public void delete(int id) {
		log.debug("------------------------ calling getStudent() method of StudentDAO class");
		studentDAO.delete(id);
		
	}

	@Override
	public void deleteSelection(int[] ids) {
		log.debug("------------------------ calling deleteSelection method of StudentDao class");
		studentDAO.deleteSelection(ids);
		
	}

	@Override
	public String getImageById(int ids) {
		log.debug("------------------ calling getImageById() method of StudentDAO class");
		String imageName = studentDAO.getImageById(ids);   
		return imageName;
	}

	@Override
	public List<ChatData> groupStudentDataByCourse() {
		log.debug("------------------ calling groupStudentDataByCourse() method of StudentDAO class");
		List<ChatData> chartDataList1 = studentDAO.groupStudentDataByCourse();   
		return chartDataList1;
	}

	@Override
	public List<ChatData> groupStudentDataByCountry() {
		log.debug("------------------ calling groupStudentDataByCountry() method of StudentDAO class");
		List<ChatData> chartDataList2 = studentDAO.groupStudentDataByCountry();   
		return chartDataList2;
	}

	@Override
	public Student findByEmailAndPassword(String email, String password) {
		log.debug("------------------------ calling findByEmailAndPassword() method of StudentDAO class");
		return studentDAO.findByEmailAndPassword(email, password);  //here we are making dao call
	}

	@Override
	public Student getStudentByEmail(String email) {
		log.debug("------------------------ calling getStudentByEmail() method of StudentDAO class");
		return studentDAO.getStudentByEmail(email);  //here we are making dao call
	}

	@Override
	public void update1(Student student1) {
		studentDAO.update1(student1);
		
	}

	

}
