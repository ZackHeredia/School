package com.school.data.contract;

public class SchoolContract
{
	public static final String DB_NAME = "schoolDB";
	public static final String DB_LOCATION = "";

	public interface PersonEntry
	{
		public static final String ID_COLUMN = "id";
		public static final String NAME_COLUMN = "name";
		public static final String BIRTH_COLUMN = "birth";
		public static final String PHONE_COLUMN = "phone";
		public static final String ADDRESS_COLUMN = "address";
	}
	
	public static final class StudentEntry implements PersonEntry
	{
		public static final String TABLE_NAME = "students";
		public static final String COURSE_COLUMN = "courses";
		public static final String TUTOR_COLUMN = "tutors";
	}
	
	public static final class TeacherEntry implements PersonEntry
	{

		public static final String TABLE_NAME = "teachers";
		public static final String SUBJECT_COLUMN = "subjects";
	}
	
	public static final class EmployeeEntry implements PersonEntry
	{

		public static final String TABLE_NAME = "employees";
		public static final String JOB_COLUMN = "jobs";
	}
}