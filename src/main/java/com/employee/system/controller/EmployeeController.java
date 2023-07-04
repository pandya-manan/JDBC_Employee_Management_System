package com.employee.system.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.employee.system.entities.Employee;
import com.employee.system.jdbc.JDBCConnection;
import com.employee.system.service.EmployeeManagementService;

public class EmployeeController {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		EmployeeManagementService service=new EmployeeManagementService();
		JDBCConnection connectionObject=new JDBCConnection();
		
		Connection connection=connectionObject.giveConnection();
		while(true)
		{
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("ENTER FROM THE FOLLOWING GIVEN CHOICES");
			System.out.println("1.INSERT A NEW EMPLOYEE");
			System.out.println("2.SELECT ALL EMPLOYEES FROM THE TABLE");
			System.out.println("3.UPDATE EMPLOYEE BASED ON EMPLOYEE ID");
			System.out.println("4.DELETE EMPLOYEE BY EMPLOYEE ID");
			System.out.println("5.EXIT THE APPLICATION");
			Integer choice=sc.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Enter the employee Id");
					Integer empId=sc.nextInt();
					System.out.println("Enter the employee name");
					String empName=sc.next();
					System.out.println("Enter the employee address");
					String empAddress=sc.next();
					System.out.println("Enter the age of the employee");
					Integer age=sc.nextInt();
					System.out.println("Enter the salary of the employee");
					Integer salary=sc.nextInt();
					System.out.println("Enter the department of the employee");
					String department=sc.next();
					Employee employeeToAdd=new Employee(empId,empName,empAddress,age,salary,department);
					Boolean additionResult=service.addNewEmployee(employeeToAdd);
					if(additionResult==true)
					{
						System.out.println("The employee "+employeeToAdd.toString()+" is added successfully");
					}
					else
					{
						System.out.println("The employee could not be added");
					}
					break;
			case 2: List<Employee> foundEmployees=service.getAllEmployees();
					if(foundEmployees.isEmpty())
					{
						System.out.println("There are no employees stored in the database");
					}
					else
					{
						for (Employee emp:foundEmployees)
						{
							System.out.println(emp.toString());
						}
					}
					break;
			case 3: System.out.println("Enter the employee Id whose details needs to be updated");
					Integer empIdUp=sc.nextInt();
					System.out.println("Enter the employee name");
					String empNameUp=sc.next();
					System.out.println("Enter the employee address");
					String empAddUp=sc.next();
					System.out.println("Enter the employee age");
					Integer empAgeUp=sc.nextInt();
					System.out.println("Enter the employee Salary");
					Integer empSalUp=sc.nextInt();
					System.out.println("Enter the employee Department");
					String empDeptUp=sc.next();
					Employee updateEmployee=new Employee(empIdUp,empNameUp,empAddUp,empAgeUp,empSalUp,empDeptUp);
					Boolean isEmployeeUpdated=service.updateExistingEmployee(updateEmployee, empIdUp);
					if(isEmployeeUpdated==true)
					{
						System.out.println("The employee "+updateEmployee+" is updated");
					}
					else
					{
						System.out.println("The employee could not be updated");
					}
					break;
			case 4: System.out.println("Enter the employee Id whose record needs to be deleted");
					Integer empDel=sc.nextInt();
					Boolean isEmployeeDeleted=service.deleteEmployee(empDel);
					if(isEmployeeDeleted==true)
					{
						System.out.println("The employee was deleted successfully");
					}
					else
					{
						System.out.println("The employee could not be deleted");
					}
					break;
			case 5: sc.close();
					connection.close();
					System.exit(0);
					break;
			}
		}
		

	}

}
