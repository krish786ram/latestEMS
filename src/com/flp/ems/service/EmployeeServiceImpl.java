package com.flp.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	
	EmployeeDaoImplForList employeeDao=new EmployeeDaoImplForList();
	
	@Override
	public void addEmployee(HashMap<String,String> dataMap) {	
		employeeDao.addEmployee(dataMap);
	}

	@Override
	public void modifyEmployee(HashMap<String,String> dataMap) {
		employeeDao.modifyEmployee(dataMap);
	}

	@Override
	public void removeEmployee(String employee_id) {
		employeeDao.removeEmployee(employee_id);	
	}

	@Override
	public Employee searchEmployee(HashMap<String,String> dataMap) {
		return employeeDao.searchEmployee(dataMap);
		
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {		
		return employeeDao.getAllEmployee();
		
	}

}
