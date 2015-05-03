package com.school.data;

import java.sql.Date;

public class Student extends Person
{
	private String course;
	private String tutor;

	public Student (long id, String name, Date birth, String phone, String address, String course, String tutor) 
	{
		super(id, name, birth, phone, address);
		
		this.course = course;
		this.tutor = tutor;
	}

	public void setCourse (String course) 
	{
		this.course = course;
	}
	public void setTutor (String tutor) 
	{
		this.tutor = tutor;
	}

	public String getCourse () 
	{
		return this.course;
	}
	public String getTutor () 
	{
		return this.tutor;
	}
}
