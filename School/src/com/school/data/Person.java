package com.school.data;

import java.sql.Date;

public abstract class Person
{
	private long id;
	private String name;
	private Date birth;
	private String phone;
	private String address;

	public Person (long id, String name, Date birth, String phone, String address) 
	{
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
	}

	public void setId (long id)
	{
		this.id = id;
	}
	public void setName (String name)
	{
		this.name = name;
	}
	public void setBirth (Date birth)
	{
		this.birth = birth;
	}
	public void setPhone (String phone)
	{
		this.phone = phone;
	}
	public void setAddress (String address)
	{
		this.address = address;
	}
	
	public long getId ()
	{
		return this.id;
	}
	public String getName ()
	{
		return this.name;
	}
	public Date getBirth ()
	{
		return this.birth;
	}
	public String getPhone ()
	{
		return this.phone;
	}
	public String getAddress ()
	{
		return this.address;
	}
}