package com.hcl.employee.service;


import java.util.ArrayList;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.deo.EmployeeDAO;
import com.hcl.employee.exception.IdException;

public class EmployeeServices {
	public static ArrayList<Employee> displayEmployees() {
		return EmployeeDAO.displayEmployees();
	}
	public static Employee addEmployee(Employee employee) throws IdException {
		return EmployeeDAO.addEmployee(employee);
	}
	public static void deleteEmployee(int id) throws IdException {
		EmployeeDAO.deleteEmployee(id);
	}
	public static void updateEmployee(Employee employee) throws IdException{
		EmployeeDAO.updateEmployee(employee);
	}
	public static ArrayList<Employee> searchEmployee(int id3) throws IdException{
		return EmployeeDAO.searchEmployee(id3);
}
}