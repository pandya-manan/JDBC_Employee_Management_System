package com.employee.system.jdbc;

public class JDBCSupport {
	
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/department";
	private static final String USERNAME="root";
	private static final String PASSWORD="12345678";
	
	public static String getUsername()
	{
		return USERNAME;
	}
	
	public static String getPassword()
	{
		return PASSWORD;
	}
	
	public static String getJdbcUrl()
	{
		return JDBC_URL;
	}

}
