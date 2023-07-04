package com.employee.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.employee.system.entities.Employee;
import com.employee.system.jdbc.JDBCConnection;
import com.employee.system.jdbc.Queries;

public class EmployeeManagementDao {
	
	JDBCConnection connectionObject=new JDBCConnection();
	
	Connection connection=connectionObject.giveConnection();
	
	Queries queries=new Queries();
	
	public Boolean addNewEmployee(Employee employee)
	{
		Boolean isEmployeeAdded=false;
		String insertQuery=queries.INSERT_QUERY;
		try
		{
			PreparedStatement ps=this.connection.prepareStatement(insertQuery);
			ps.setInt(1, employee.getEmployeeId());
			ps.setString(2, employee.getEmployeeName());
			ps.setString(3, employee.getEmployeeAddress());
			ps.setInt(4,employee.getEmployeeAge());
			ps.setInt(5, employee.getEmployeeSalary());
			ps.setString(6, employee.getEmployeeDepartment());
			int insertionCount=ps.executeUpdate();
			if(insertionCount==1)
			{
				isEmployeeAdded=true;
			}		
			
		}catch(Exception e)
		{
			System.out.println("The exception caught during addition of new employee record is: "+e.getMessage());
		}
		return isEmployeeAdded;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<Employee>();
		String query=queries.SELECT_ALL_EMPLOYEES;
		try
		{
			Statement statement=this.connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			while(rs.next())
			{
				Employee found=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
				employees.add(found);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("The exception caught while getting all employees stored in the database "+e.getMessage());
		}
		return employees;
		
	}
	
	public Boolean updateEmployeeDetails(Employee employee,Integer employeeId)
	{
		Boolean isEmployeeUpdated=false;
		String updateQuery=queries.UPDATE_EMPLOYEE_DETAILS;
		try
		{
			PreparedStatement ps=this.connection.prepareStatement(updateQuery);
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2,employee.getEmployeeAddress());
			ps.setInt(3, employee.getEmployeeAge());
			ps.setInt(4, employee.getEmployeeSalary());
			ps.setString(5, employee.getEmployeeDepartment());
			ps.setInt(6, employee.getEmployeeId());
			Integer updationCount=ps.executeUpdate();
			if(updationCount==1)
			{
				isEmployeeUpdated=true;
			}
			
				
		}catch(Exception e)
		{
			System.out.println("The Exception caught while updating the employee is: "+e.getMessage());
		}
		return isEmployeeUpdated;
	}
	
	public Boolean deleteEmployeeByEmployeeId(Integer empId)
	{
		String deleteQuery=queries.DELETE_EMPLOYEE;
		Boolean isEmployeeDeleted=false;
		try
		{
			PreparedStatement ps=this.connection.prepareStatement(deleteQuery);
			ps.setInt(1, empId);
			Integer deletionCount=ps.executeUpdate();
			if(deletionCount==1)
			{
				isEmployeeDeleted=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("The deletion operation encountered an exception: "+e.getMessage());
		}
		return isEmployeeDeleted;
	}
			

}
