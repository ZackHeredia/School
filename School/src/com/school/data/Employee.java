package com.school.data;

import java.sql.Date;

public class Employee extends Person
{
	private String job;

	public Employee (long id, String name, Date birth, String phone, String address, String job) 
	{
		super(id, name, birth, phone, address);
		
		this.job = job;
	}

	public void setJob (String job) 
	{
		this.job = job;
	}

	public String getJob () 
	{
		return this.job;
	}
}
