package com.school.data;

import com.school.data.contract.SchoolContract;
import com.school.data.contract.SchoolContract.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		String sql = null;
		long id = parseLong(value);
		Date birth = parseDate(value);
		ArrayList<Student> students = new ArrayList<Student>();
		
		if(id != -1)
		{
			sql = "SELECT * FROM " + StudentEntry.TABLE_NAME + " WHERE " + StudentEntry.ID_COLUMN + 
				  "=" + value;
		}
		else if(birth != null)
		{
			sql = "SELECT * FROM " + StudentEntry.TABLE_NAME + " WHERE " + StudentEntry.BIRTH_COLUMN +
				  "=" + value;
		}
		else
			sql = "SELECT * FROM " + StudentEntry.TABLE_NAME + " WHERE " + StudentEntry.NAME_COLUMN +
				  "=" + value + " OR " + StudentEntry.PHONE_COLUMN + "=" + value + " OR " + 
				  StudentEntry.ADDRESS_COLUMN + "=" + value + " OR " + StudentEntry.COURSE_COLUMN +
				  "=" + value + " OR " + StudentEntry.TUTOR_COLUMN + "=" + value;
		
		try
		{
			ResultSet rs = executeQueryForResult(sql);
			
			while(rs.next())
			{
				students.add(new Student(rs.getLong(StudentEntry.ID_COLUMN), 
							 			 rs.getString(StudentEntry.NAME_COLUMN),
							 			 rs.getDate(StudentEntry.BIRTH_COLUMN),
							 			 rs.getString(StudentEntry.PHONE_COLUMN),
							 			 rs.getString(StudentEntry.ADDRESS_COLUMN),
							 			 rs.getString(StudentEntry.COURSE_COLUMN),
							 			 rs.getString(StudentEntry.TUTOR_COLUMN)));
			}
			
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return students;
	}
	public ArrayList<Teacher> selectTeachers (String value) 
	{
		String sql = null;
		long id = parseLong(value);
		Date birth = parseDate(value);
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		
		if(id != -1)
		{
			sql = "SELECT * FROM " + TeacherEntry.TABLE_NAME + " WHERE " + TeacherEntry.ID_COLUMN + 
				  "=" + value;
		}
		else if(birth != null)
		{
			sql = "SELECT * FROM " + TeacherEntry.TABLE_NAME + " WHERE " + TeacherEntry.BIRTH_COLUMN +
				  "=" + value;
		}
		else
			sql = "SELECT * FROM " + TeacherEntry.TABLE_NAME + " WHERE " + TeacherEntry.NAME_COLUMN +
				  "=" + value + " OR " + TeacherEntry.PHONE_COLUMN + "=" + value + " OR " + 
				  TeacherEntry.ADDRESS_COLUMN + "=" + value + " OR " + TeacherEntry.SUBJECT_COLUMN +
				  "=" + value;
		
		try
		{
			ResultSet rs = executeQueryForResult(sql);
			
			while(rs.next())
			{
				teachers.add(new Teacher(rs.getLong(TeacherEntry.ID_COLUMN), 
							 			 rs.getString(TeacherEntry.NAME_COLUMN),
							 			 rs.getDate(TeacherEntry.BIRTH_COLUMN),
							 			 rs.getString(TeacherEntry.PHONE_COLUMN),
							 			 rs.getString(TeacherEntry.ADDRESS_COLUMN),
							 			 rs.getString(TeacherEntry.SUBJECT_COLUMN)));
			}
			
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return teachers;
	}
	public ArrayList<Employee> selectEmployees (String value) 
	{
		String sql = null;
		long id = parseLong(value);
		Date birth = parseDate(value);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		if(id != -1)
		{
			sql = "SELECT * FROM " + EmployeeEntry.TABLE_NAME + " WHERE " + EmployeeEntry.ID_COLUMN + 
				  "=" + value;
		}
		else if(birth != null)
		{
			sql = "SELECT * FROM " + EmployeeEntry.TABLE_NAME + " WHERE " + EmployeeEntry.BIRTH_COLUMN +
				  "=" + value;
		}
		else
			sql = "SELECT * FROM " + EmployeeEntry.TABLE_NAME + " WHERE " + EmployeeEntry.NAME_COLUMN +
				  "=" + value + " OR " + EmployeeEntry.PHONE_COLUMN + "=" + value + " OR " + 
				  EmployeeEntry.ADDRESS_COLUMN + "=" + value + " OR " + EmployeeEntry.JOB_COLUMN +
				  "=" + value;
		
		try
		{
			ResultSet rs = executeQueryForResult(sql);
			
			while(rs.next())
			{
				employees.add(new Employee(rs.getLong(EmployeeEntry.ID_COLUMN), 
							 			 rs.getString(EmployeeEntry.NAME_COLUMN),
							 			 rs.getDate(EmployeeEntry.BIRTH_COLUMN),
							 			 rs.getString(EmployeeEntry.PHONE_COLUMN),
							 			 rs.getString(EmployeeEntry.ADDRESS_COLUMN),
							 			 rs.getString(EmployeeEntry.JOB_COLUMN)));
			}
			
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return employees;
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
							"))";
			
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
	
	private long parseLong (String string)
	{	
		long result;
		
		try
		{
			result = Long.parseLong(string);
		}
		catch(NumberFormatException e)
		{
			return -1;
		}
		
		return result;
	}
	private Date parseDate (String string)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		Date date;
		
		try
		{
			date = (Date) sdf.parse(string);
		}
		catch(ParseException e)
		{
			return null;
		}
		
		return date;
	}
}