package com.school.data;

import com.school.data.contract.SchoolContract;
import com.school.data.contract.SchoolContract.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBHelper
{
	private Connection connection;
	private DBHelper helper = null;

	private DBHelper() 
	{
		String url = "jdbc:derby:data/" + SchoolContract.DB_NAME + ";create=true";
		
		try
		{
			connection = DriverManager.getConnection(url);
			createTables();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public DBHelper getHelperInstance () 
	{
		if (helper == null)
			helper = new DBHelper();
		
		return helper;
	}

	public Student[] selectStudents (String value) 
	{	
		return (Student[]) select(value, StudentEntry.TABLE_NAME);
	}
	public Teacher[] selectTeachers (String value) 
	{
		return (Teacher[]) select(value, TeacherEntry.TABLE_NAME);
	}
	public Employee[] selectEmployees (String value) 
	{
		return (Employee[]) select(value, EmployeeEntry.TABLE_NAME);
	}

	public boolean insertStudent (Student student) 
	{
		return insert(student, StudentEntry.TABLE_NAME);
	}
	public boolean insertTeacher (Teacher teacher) 
	{
		return insert(teacher, TeacherEntry.TABLE_NAME);
	}
	public boolean insertEmployee (Employee employee) 
	{
		return insert(employee, EmployeeEntry.TABLE_NAME);
	}

	public boolean updateStudent (Student student) 
	{
		return update(student, StudentEntry.TABLE_NAME);
	}
	public boolean updateTeacher (Teacher teacher) 
	{
		return update(teacher, TeacherEntry.TABLE_NAME);
	}
	public boolean updateEmployee (Employee employee) 
	{
		return update(employee, EmployeeEntry.TABLE_NAME);
	}

	public boolean deleteStudent (long id) 
	{
		return delete(id, StudentEntry.TABLE_NAME);
	}
	public boolean deleteTeacher (long id) 
	{
		return delete(id, TeacherEntry.TABLE_NAME);
	}
	public boolean deleteEmployee (long id) 
	{
		return delete(id, EmployeeEntry.TABLE_NAME);
	}

	private void createTables () throws SQLException
	{
		DatabaseMetaData dbmd = connection.getMetaData();
		
		ResultSet rs = dbmd.getTables(null, null, "%", null);
		if(!rs.next())
		{
			String sqlPerson = " (" + PersonEntry.ID_COLUMN + " LONG NOT NULL GENERATED " +
							   "ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							   PersonEntry.NAME_COLUMN + " VARCHAR(40), " + 
							   PersonEntry.PHONE_COLUMN + " VARCHAR(16), " + 
							   PersonEntry.ADDRESS_COLUMN + " VARCHAR(160), " +
							   PersonEntry.BIRTH_COLUMN + " DATE, ";
			String sqlStudent = StudentEntry.COURSE_COLUMN + " VARCHAR(10), " +
							   	StudentEntry.TUTOR_COLUMN + " VARCHAR(40), ";
			String sqlTeacher = TeacherEntry.SUBJECT_COLUMN + " VARCHAR(24), ";
			String sqlEmployee = EmployeeEntry.JOB_COLUMN + " VARCHAR(24), ";
			String sqlKey = "CONSTRAINT primary_key PRIMARY KEY (" + PersonEntry.ID_COLUMN + 
							"));";
			
			String sql = "CREATE TABLE " + StudentEntry.TABLE_NAME + sqlPerson + 
						 sqlStudent + sqlKey;	
			Statement stmTables = connection.createStatement();
			stmTables.execute(sql);
			
			sql = "CREATE TABLE " + TeacherEntry.TABLE_NAME + sqlPerson + 
					 sqlTeacher + sqlKey;	
			stmTables = connection.createStatement();
			stmTables.execute(sql);
			
			sql = "CREATE TABLE " + EmployeeEntry.TABLE_NAME + sqlPerson + 
					 sqlEmployee + sqlKey;	
			stmTables = connection.createStatement();
			stmTables.execute(sql);
		}
	}
	
	private ResultSet select (String sql) 
	{
		
	}
	private boolean insert (Person person, String table) 
	{
		
	}
	private boolean update (Person person, String table) 
	{
		
	}
	public boolean delete (long id, String table)
	{
		
	}
}