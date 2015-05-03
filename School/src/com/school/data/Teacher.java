package com.school.data;

import java.sql.Date;

public class Teacher extends Person
{
	private String subject;

	public Teacher (long id, String name, Date birth, String phone, String address, String subject) 
	{
		super(id, name, birth, phone, address);
		
		this.subject = subject;
	}

	public void setSubject (String subject) 
	{
		this.subject = subject;
	}

	public String getSubject () 
	{
		return this.subject;
	}
}
