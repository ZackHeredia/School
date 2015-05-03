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

	public ArrayList<Student> selectStudents (String value) 
	{	
		
		String sql;
		
		try
		{
			ResultSet rs = executeQueryForResult(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public ArrayList<Teacher> selectTeachers (String value) 
	{
		String sql;
		
		try
		{
			ResultSet rs = executeQueryForResult(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public ArrayList<Employee> selectEmployees (String value) 
	{
		String sql;
		ResultSet rs;
		
		try
		{
			rs = executeQueryForResult(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public boolean insertStudent (Student student) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}
	public boolean insertTeacher (Teacher teacher) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}
	public boolean insertEmployee (Employee employee) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}

	public boolean updateStudent (Student student) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}
	public boolean updateTeacher (Teacher teacher) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;;
	}
	public boolean updateEmployee (Employee employee) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}

	public boolean deleteStudent (long id) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}
	public boolean deleteTeacher (long id) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
	}
	public boolean deleteEmployee (long id) 
	{
		String sql;
		boolean isSuccessfull;
		
		try
		{
			isSuccessfull= executeQuery(sql);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccessfull;
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
			executeQuery(sql);
			
			sql = "CREATE TABLE " + TeacherEntry.TABLE_NAME + sqlPerson + 
					 sqlTeacher + sqlKey;	
			executeQuery(sql);
			
			sql = "CREATE TABLE " + EmployeeEntry.TABLE_NAME + sqlPerson + 
					 sqlEmployee + sqlKey;	
			executeQuery(sql);
		}
	}
	
	private ResultSet executeQueryForResult (String sql) throws SQLException 
	{
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		return rs;
	}
	private boolean executeQuery (String sql) throws SQLException 
	{
		Statement stmTables = connection.createStatement();
		boolean isSuccessfull = stmTables.execute(sql);
		
		return isSuccessfull;
	}
}