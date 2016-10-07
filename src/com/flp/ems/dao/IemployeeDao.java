package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {

	public void addEmployee(HashMap<String,String> dataMap);
	public void modifyEmployee(HashMap<String,String> dataMap);
	public void removeEmployee(String employee_id);
	public Employee searchEmployee(HashMap<String,String> dataMap);
	public ArrayList<Employee> getAllEmployee();
	
}
