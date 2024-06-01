package com.sm.dao;
//it is a dao layer. all db related code will be here

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sm.api.ChatData;
import com.sm.api.Student;
import com.sm.config.HibernateConfig;
import com.sm.controllers.StudentController;

import jakarta.persistence.NoResultException;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private static final Logger log = LogManager.getLogger(StudentController.class.getName());

	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	@Override
	public List<Student> loadStudents() {
		log.debug("------------------ called loadStudents() method");
		// logic to get student data from db
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createQuery("from Student", Student.class).list(); // HQL
		for (Student s : studentList) {
			log.info("Student List::" + s);
		}
		session.close();
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		// logic to save data to db
		log.debug("------------------------ called saveStudent() method ");
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			int current_rollNo = student.getRollno();
			Long current_mobile = student.getMobile();
			String current_emailid = student.getEmail();
			log.info(current_rollNo + " " + current_mobile + " " + current_emailid);
			List<Student> studentList = session.createQuery("from Student", Student.class).list();
			insert: {
				for (Student s : studentList) {
					if (s.getRollno() == current_rollNo || s.getMobile().equals(current_mobile)
							|| s.getEmail().equals(current_emailid)) {
						log.info("duplicate entries");
						break insert; // control comes out of insert block
					}
				}
				session.save(student);
				session.getTransaction().commit();
				log.info("------------------------ 1 record inserted");
				session.close();
			}
		} catch (HibernateException e) {
			log.error("Error during insert operation", e);
		}
	}

	@Override
	public Student getStudent(int id) {
		log.debug("------------------------ called getStudent() method ");
		// logic to fetch a student by using id
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.getTransaction().commit();
		log.info("student fetched : " + student);
		session.close();
		return student;

	}
	

	@Override
	public void update(Student student) {
		// logic to update a student record
		log.debug("------------------------ called update() method ");
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(student);
			session.getTransaction().commit();
			log.info("------------------------ 1 record updated");
			System.out.println("1 record updated");
			session.close();
		} catch (HibernateException e) {
			log.error("Error during update operation", e);
		}
	}
	
	
	@Override
	public void update1(Student student1) {
		log.debug("------------------------ called update1() method ");
		
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Student s = getStudent(student1.getId());
			s.setId(student1.getId());
			s.setRollno(student1.getRollno());
			s.setFname(student1.getFname());
			s.setLname(student1.getLname());
			s.setDob(student1.getDob());
			s.setGender(student1.getGender());
			s.setEmail(student1.getEmail());
			s.setPassword(student1.getPassword());
			s.setMobile(student1.getMobile());
			s.setCourse(student1.getCourse());
			s.setCountry(student1.getCountry());
			session.update(s);
			session.getTransaction().commit();
			log.info("------------------------ 1 record updated");
			System.out.println("1 record updated");
			session.close();
		} catch (HibernateException e) {
			log.error("Error during update operation", e);
		}
		
		
	}

	
	
	@Override
	public void delete(int id) {
		// logic to delete the student
		try {
			log.debug("------------------------ called delete() method ");
			Session session = sessionFactory.openSession();
			Student student = session.byId(Student.class).load(id);
			log.info("student fetched : " + student);
			session.beginTransaction();
			session.delete(student);
			session.getTransaction().commit();
			log.info("------------------------ 1 record deleted");
			System.out.println("1 record deleted");
			session.close();
		} catch (HibernateException e) {
			log.error("Error during delete operation", e);
		}
	}

	@Override
	public void deleteSelection(int[] ids) {
		// logic to delete the selected students
		try {
			log.debug("------------------------ called deleteSelection() method ");
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			// first convert the int[] array to a Stream<Integer> using the Arrays.stream
			// method, then
			// use the boxed method to convert each int to an Integer,
			// and finally use the collect method to convert the Stream to a List<Integer>.

			List<Integer> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
			Query query = session.createQuery("delete from Student where id in (:ids)");
			query.setParameterList("ids", idList);
			query.executeUpdate();
			session.getTransaction().commit();
			log.info("------------------------ record deleted");
			session.close();
		} catch (HibernateException e) {
			log.error("Error during deleteSelection operation", e);
		}

	}

	@Override
	public String getImageById(int ids) {
		// logic to get image of the student

		log.debug("------------------------ called getImageById() method ");
		Session session = sessionFactory.openSession();
		Student student = session.byId(Student.class).load(ids);
		session.close();
		return student.getImageName();

	}

	@Override
	public List<ChatData> groupStudentDataByCourse() {
		
		log.debug("------------------------ called groupStudentDataByCourse() method ");
		Session session = sessionFactory.openSession();
	    String hql = "SELECT s.course, COUNT(*) FROM Student s GROUP BY s.course";
	    Query query = session.createQuery(hql);
	    List<Object[]> results = query.list();
	    List<ChatData> chartDataList1 = new ArrayList<>();
	    for (Object[] result : results) {
	        String course = (String) result[0];
	        Long count = (Long) result[1];
			log.debug("course :" +course);
			log.debug("count :" +count);
			chartDataList1.add(new ChatData(course, count.intValue()));
	    }
	    session.close();
	    return chartDataList1;
	}

	@Override
	public List<ChatData> groupStudentDataByCountry() {
		log.debug("------------------------ called groupStudentDataByCountry() method ");
		Session session = sessionFactory.openSession();
	    String hql = "SELECT s.country, COUNT(*) FROM Student s GROUP BY s.country";
	    Query query = session.createQuery(hql);
	    List<Object[]> results = query.list();
	    List<ChatData> chartDataList2 = new ArrayList<>();
	    for (Object[] result : results) {
	        String country = (String) result[0];
	        Long count = (Long) result[1];
			log.debug("course :" +country);
			log.debug("count :" +count);
			chartDataList2.add(new ChatData(country, count.intValue()));
	    }
	    session.close();
	    return chartDataList2;
	}

	@Override
	public Student findByEmailAndPassword(String email, String password) {
		log.debug("------------------------ called findByEmailAndPassword() method ");
		Session session = sessionFactory.openSession();
		String hql = "FROM Student s WHERE s.email = :email AND s.password = :password";
	    Query query = session.createQuery(hql);
	    query.setParameter("email", email);
        query.setParameter("password", password);
        List<Student> results = query.getResultList();
        session.close();
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);   //the first element of the list is returned.
        }
	}
   
	public Student getStudentByEmail(String email) {
		log.debug("------------------------ called getStudentByEmail() method ");
		log.info("email id of the student :" +email);
		Session session = sessionFactory.openSession();
        Query<Student> query = session.createQuery("from Student where email=:email", Student.class);
        query.setParameter("email", email);
        Student student = null;
        try {
            student = query.getSingleResult();
        } catch (NoResultException ex) {
            student = null;
        }
        session.close();
        return student;
    }

	
	
}
