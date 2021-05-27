package com.hcl.employee.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.exception.IdException;
import com.hcl.employee.service.EmployeeServices;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stu

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1 to display the list of employees \n"
					+ "Enter 2 to insert Values into the table \n" + "Enter 3 to delete employee details \n"
					+ "Enter 4 to update the details \n" + "Enter 5 to search the employee \n" + "Enter 6 to exit");
			int option = sc.nextInt();
			switch (option) {
				 case 1:
					 ArrayList<Employee> emp = EmployeeServices.displayEmployees();
				      for(Employee e:emp) 
				      {
					 System.out.println(e.toString());
				      }
					 break;

			case 2:
				System.out.println("enter employee id");
				int id = sc.nextInt();
				System.out.println("enter employee Name");
				String name = sc.next();
				System.out.println("enter employee department");
				String department = sc.next();
				System.out.println("enter employee Salary");
				float salary = sc.nextInt();
				Employee employee = new Employee();
				employee.setId(id);
				employee.setDepartment(department);
				employee.setName(name);
				employee.setSalary(salary);
				try {
					employee = EmployeeServices.addEmployee(employee);
				} catch (IdException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case 3:
				System.out.println("enter the id for deletion");
				int id1 = sc.nextInt();
				Employee employee1 = new Employee();
				employee1.setId(id1);
				try {
					EmployeeServices.deleteEmployee(id1);
				} catch (IdException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				System.out.println("enter the id");
				int id2 = sc.nextInt();
				System.out.println("enter the department");
				String department1 = sc.next();
				Employee employee2 = new Employee();
				employee2.setId(id2);
				employee2.setDepartment(department1);
				try {
					EmployeeServices.updateEmployee(employee2);
				} catch (IdException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
				 case 5:
					 System.out.println("enter the id");
					 int id3= sc.nextInt();					 
				ArrayList<Employee> emp1;
				try {
					emp1 = EmployeeServices.searchEmployee(id3);
					if(emp1.size()==0) {
						System.out.println("No data found");
					}
					else {
					for(Employee e:emp1) {
						System.out.println(e.toString());
					}
					}
				} catch (IdException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					 break;
			case 6:
				// Connection con = DBConnection.getConnection();
//						 try {
//							con.close();
//						} catch (SQLException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
				System.out.println("Connection Closed");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid option");
				break;
			}

		}

	}
}
