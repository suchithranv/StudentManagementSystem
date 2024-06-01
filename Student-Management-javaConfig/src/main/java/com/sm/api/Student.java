package com.sm.api;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

//this is pojo/domain class
//used only for store and retrieve purpose 
//now we are using this class in DAO layer(StudentDAO) also and as DTO(StudentController) also.

@Entity
public class Student {
	
	@Id
	private int id;
	private int rollno;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private String email;
	private String password;
	private Long mobile;
	private String course;
	private String country;
	@Transient
	private MultipartFile multipartFile;
	@Lob
	private byte[] image;
	private String imageName;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	public Student(int id, int rollno, String fname, String lname, String dob, String gender, String email, String password, Long mobile,
			String course, String country) {
		
		super();
		System.out.println("student constructor without image is called");
		this.id = id;
		this.rollno = rollno;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.course = course;
		this.country = country;
	}
	
	

	
	public Student(int id, int rollno, String fname, String lname, String dob, String gender, String email,
			String password, Long mobile, String course, String country, byte[] image, MultipartFile multipartFile,
			String imageName) {
		super();
		System.out.println("student constructor with image is called");
		this.id = id;
		this.rollno = rollno;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.course = course;
		this.country = country;
		this.image = image;
		this.multipartFile = multipartFile;
		this.imageName = imageName;
	}
	
	
	public Student() {
		super();
		System.out.println("default student constructor is called");
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollno=" + rollno + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", password=" + password + ", mobile=" + mobile
				+ ", course=" + course + ", country=" + country + ", imageName=" + imageName + "]";
	}
	
	

}
