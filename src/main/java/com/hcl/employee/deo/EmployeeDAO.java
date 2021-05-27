package com.hcl.employee.deo;


import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.exception.IdException;
import com.hcl.employee.util.ConnectionUtil;


public class EmployeeDAO {
	//Searching
	public static ArrayList<Employee> searchEmployee(int id3) throws IdException {	
		ArrayList<Employee> list = new ArrayList<Employee>();
		if(searchById(id3)) {
		JdbcTemplate template = ConnectionUtil.getConnection() ;
		String sql = "select Id,Name,Department, Salary from employee where id=?";
		list = (ArrayList<Employee>) template.query(sql, new EmployeeMapper(),id3);
		}
		else {
			throw new IdException("Cannot Search as employee id doesn't exists");
		}
		return list;

	}
//	//Updating
public static void updateEmployee(Employee employee) throws IdException {
	if(searchById(employee.getId())) {
		JdbcTemplate template = ConnectionUtil.getConnection() ;
		String sql = "update employee set department=? where id=?";
		template.update(sql,employee.getDepartment(),employee.getId());
	}
	else {
		throw new IdException("Employee Id doesnotExists cannot update");
	}
	}
	
	//deleting values
	public static void deleteEmployee(int id) throws IdException{
		if(searchById(id)) {
		JdbcTemplate template = ConnectionUtil.getConnection() ;
		String sql = "delete from employee where id=?";
		template.update(sql,id);
		}
		else {
			throw new IdException("Employee Id doesnotExists cannot delete");
		}
	
}

	//inserting values 
	public static Employee addEmployee(Employee employee) throws IdException {
		if(!searchById(employee.getId())) {
		JdbcTemplate template = ConnectionUtil.getConnection() ;
		String sql ="insert into employee values(?,?,?,?)";
		template.update(sql,employee.getId(),employee.getName(),employee.getDepartment(),employee.getSalary());
		return employee;
		}
		else {
			throw new IdException("Employee Id already exists cannot add");
		}
}
	
	//Displaying Tables
	
	public static ArrayList<Employee> displayEmployees() {
		JdbcTemplate template = ConnectionUtil.getConnection() ;
		String sql = "select Id,Name,Department, Salary from employee";
		ArrayList<Employee> list = (ArrayList<Employee>) template.query(sql, new EmployeeMapper());
		return list;	
	}
	public static boolean searchById(int id) {
		JdbcTemplate template = ConnectionUtil.getConnection() ;
		String sql = "select Id,Name,Department, Salary from employee where id=?";
		ArrayList<Employee> list = (ArrayList<Employee>) template.query(sql, new EmployeeMapper(),id);
		if(list.size()==0)
			return false;
		else
			return true;
		
	}
	
}
