package com.flp.ems.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.service.AutoGenerate;

public class EmployeeDaoImplForList implements IemployeeDao{

	static ArrayList<Employee> employees=new ArrayList<>();
	AutoGenerate generate=new AutoGenerate();
	@Override
	public void addEmployee(HashMap<String,String> dataMap) {
		String department_id=dataMap.get("department_id");
		String department_name=dataMap.get("department_name");
		
		Department dept=new Department(department_id, department_name);
		
		String role_id=dataMap.get("role_id");
		String role_name=dataMap.get("role_name");
		
		Role role=new Role(role_id, role_name);
		
		String project_id=dataMap.get("project_id");
		String project_name=dataMap.get("project_name");
		
		Project proj=new Project(project_id, project_name, department_id);
		
		String name=dataMap.get("name");
		String phone_number=dataMap.get("phone_number");
		String address=dataMap.get("address");
		String date_of_birth=dataMap.get("date_of_birth");
		String date_of_joining=dataMap.get("date_of_joining");
		String employee_id=generate.autogenerateID();
		String email_id=generate.autoGenerateEmailId(name);
		
		Date dob = null,doj = null;
		String format="dd-mm-yyyy";
		SimpleDateFormat dformat = new SimpleDateFormat(format);
		
		try {
			dob=dformat.parse(date_of_birth);
			doj=dformat.parse(date_of_joining);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee employee=new Employee(name,phone_number,
				address,dob,doj,employee_id,email_id);
		
		employees.add(employee);
		
	}

	@Override
	public void modifyEmployee(HashMap<String,String> dataMap) {
		String employee_id=dataMap.get("employee_id");
		
		for(Employee employee:employees){
			if(employee.getEmployee_id()==employee_id){

				if(dataMap.containsKey("name"))
					employee.setName(dataMap.get("name"));
				
				if(dataMap.containsKey("phone_number"))
					employee.setPhone_number(dataMap.get("phone_number"));
				
				if(dataMap.containsKey("address"))
					employee.setAddress(dataMap.get("address"));
				
				break;
			}
		}	
	}

	@Override
	public void removeEmployee(String employee_id) {
		for(Employee employee:employees){
			if(employee.getEmployee_id()==employee_id){
				employees.remove(employee);
				break;
			}
		}
	}

	@Override
	public Employee searchEmployee(HashMap<String,String> dataMap) {
		
		if(dataMap.containsKey("employee_id")){
			for(Employee employee:employees){
				if(employee.getEmployee_id().equals(dataMap.get("employee_id"))){
					return employee;
				}
			}
		}
		
	  if(dataMap.containsKey("email_id")){
			for(Employee employee:employees){
				if(employee.getEmail_id().equals(dataMap.get("email_id"))){
					return employee;
				}
			}	
		}
		
	  if(dataMap.containsKey("first_name")){		
			for(Employee employee:employees){
				if(employee.getName().equals(dataMap.get("name"))){
					return employee;
				}
			}	
		}
	  
	return null;
		
		
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		return employees;	
	}

}
