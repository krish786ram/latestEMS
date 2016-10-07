package com.flp.ems.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {
	
	public void addEmployee(HashMap<String,String> dataMap);
	public void modifyEmployee(HashMap<String,String> dataMap);
	public void removeEmployee(String employee_id);
	public Employee searchEmployee(HashMap<String,String> dataMap);
	public ArrayList<Employee> getAllEmployee();
	
}
