package com.sm.api;

public class ChatData {
	
	private String course;
	private int count;
	private String country;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ChatData(String course, int count) {
		super();
		this.course = course;
		this.count = count;
	}
	@Override
	public String toString() {
		return "ChatData [course=" + course + ", count=" + count + ", country=" + country + "]";
	}
	
	
}
