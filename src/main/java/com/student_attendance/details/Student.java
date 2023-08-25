package com.student_attendance.details;

import java.sql.Date;

public class Student {
	
	private int roll_no;
	private String attendance;
	private Date date;

	public Student() {
		super();
	}
	
	public Student(int roll_no, String attendance, Date date) {
		this.roll_no = roll_no;
		this.attendance = attendance;
		this.date = date;
	}
	
	public Student(String attendance, Date date) {
		this.attendance = attendance;
		this.date = date;
	}

	public String getAttendance() {
		return attendance;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getRoll_no() {
		return roll_no;
	}
	
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
}
