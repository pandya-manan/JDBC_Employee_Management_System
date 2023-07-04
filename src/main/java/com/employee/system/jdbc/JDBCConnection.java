package com.employee.system.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	private Connection connectionToDb;
	
	public JDBCConnection()
	{
		super();
		try
		{
			connectionToDb=DriverManager.getConnection(JDBCSupport.getJdbcUrl(), JDBCSupport.getUsername(), JDBCSupport.getPassword());
			System.out.println("The connection is established successfully to the database");
		}
		catch(Exception e)
		{
			System.out.println("The exception caught while connecting to the database is "+e.getMessage());
		}
	}
	
	public Connection giveConnection()
	{
		return this.connectionToDb;
	}
	
	public void closeConnection() throws SQLException
	{
		this.connectionToDb.close();
	}
	
	

}
