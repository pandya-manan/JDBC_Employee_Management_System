package com.employee.system.service;

import java.util.List;

import com.employee.system.dao.EmployeeManagementDao;
import com.employee.system.entities.Employee;

public class EmployeeManagementService {
	
	EmployeeManagementDao dao=new EmployeeManagementDao();
	
	
	public Boolean addNewEmployee(Employee employee)
	{
		return this.dao.addNewEmployee(employee);
	}
	
	public List<Employee> getAllEmployees()
	{
		return this.dao.getAllEmployees();
	}
	
	public Boolean updateExistingEmployee(Employee employee,Integer employeeId)
	{
		return this.dao.updateEmployeeDetails(employee, employeeId);
	}
	
	public Boolean deleteEmployee(Integer delId)
	{
		return this.dao.deleteEmployeeByEmployeeId(delId);
	}

}
