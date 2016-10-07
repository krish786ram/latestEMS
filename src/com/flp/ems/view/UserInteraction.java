package com.flp.ems.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {
	Scanner sc;
	UserInteraction(){
		sc=new Scanner(System.in);
	}
	
	EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
	
	String name,phone_number,address,date_of_birth,date_of_joining;
	String department_id,department_name,role_id,role_name,project_id,project_name;
	
	public void addEmployee(){		
		HashMap<String,String> dataMap=new HashMap<>();
		System.out.println("Enter Employee Information");
		System.out.println("Enter a name");
		name=sc.nextLine();
		dataMap.put("name",name);
		
		System.out.println("Enter phone number");
		phone_number=sc.nextLine();
		dataMap.put("phone_number",phone_number);
		
		System.out.println("Enter a address");
		address=sc.nextLine();
		dataMap.put("address",address);
		
		System.out.println("Enter a date of birth");
		date_of_birth=sc.nextLine();
		dataMap.put("date_of_birth",date_of_birth);
		
		System.out.println("Enter a date of joining");
		date_of_joining=sc.nextLine();
		dataMap.put("date_of_joining",date_of_joining);
		
		System.out.println("Enter a department id");
		department_id=sc.nextLine();
		dataMap.put("department_id",department_id);
		
		System.out.println("Enter a department name");
		department_name=sc.nextLine();
		dataMap.put("department_name",department_name);
		
		System.out.println("Enter a role id");
	    role_id=sc.nextLine();
	    dataMap.put("role_id",role_id);
	    
	    System.out.println("Enter a role name");
	    role_name=sc.nextLine();
	    dataMap.put("role_name",role_name);
	    
	    System.out.println("Enter a project id");
		project_id=sc.nextLine();
		dataMap.put("project_id",project_id);
		
		System.out.println("Enter a project name");
		project_name=sc.nextLine();
		dataMap.put("project_name",project_name);
		
		employeeServiceImpl.addEmployee(dataMap);
		
	}
	
	public void modifyEmployee(){
		HashMap<String,String> dataMap=new HashMap<>();
		
		System.out.println("Enter employee id to modify data of an employee");
		String employee_id=sc.next();
		dataMap.put("employee_id",employee_id);
		
		
		System.out.println("Modify data of an employee ");
		
		System.out.println("Do you want to modify name ?");
		System.out.println("1.No 2.Yes");
		int choice=sc.nextInt();
		if(choice==2){
		name=sc.next();
		dataMap.put("name",name);
		}
		 
		System.out.println("Do you want to modify phone number ?");
		System.out.println("1.No 2.Yes");
		choice=sc.nextInt();
		if(choice==2){
		System.out.println("Enter phone number");
		phone_number=sc.next();
		dataMap.put("phone_number",phone_number);
		}
		
		System.out.println("Do you want to modify address ?");
		System.out.println("1.No 2.Yes");
		choice=sc.nextInt();
		if(choice==2){
		System.out.println("Enter a address");
		address=sc.next();
		dataMap.put("address",address);
		}
		
		System.out.println("Do you want to modify department id ?");
		System.out.println("1.No 2.Yes");
		choice=sc.nextInt();
		if(choice==2){
		System.out.println("Enter a department id");
		department_id=sc.next();
		dataMap.put("department_id",department_id);
		}
		
		System.out.println("Do you want to modify role id ?");
		System.out.println("1.No 2.Yes");
		choice=sc.nextInt();
		if(choice==2){
		System.out.println("Enter a role id");
	    role_id=sc.next();
	    dataMap.put("role_Sid",role_id);
		}
		
		System.out.println("Do you want to modify project id ?");
		System.out.println("1.No 2.Yes");
		choice=sc.nextInt();
		if(choice==2){
	    System.out.println("Enter a project id");
		project_id=sc.next();
		dataMap.put("project_id",project_id);
		}
		employeeServiceImpl.modifyEmployee(dataMap);
	}
	
	public void removeEmployee(){	
		System.out.println("Enter employee id to remove an employee");
		String employee_id=sc.next();
		
		System.out.println("Are you sure you want to remove this employee?");
		System.out.println("1.No 2.Yes");
		int choice=sc.nextInt();
		
		if(choice==2)
			employeeServiceImpl.removeEmployee(employee_id);
		
	}
	
	public boolean searchEmployee(){
		
		System.out.println("Search Emloyee");
		
		HashMap<String,String> dataMap=new HashMap<>();
		
		System.out.println("Do you know employee id ?");
		System.out.println("1.YES 2.NO");
		int choice=sc.nextInt();
		if(choice==1){
			System.out.println("Enter employee id");
			String employee_id=sc.next();
			dataMap.put("employee_id", employee_id);
		}
		
		System.out.println("Do you know first name of an employee ?");
		System.out.println("1.YES 2.NO");
		choice=sc.nextInt();
		if(choice==1){
			System.out.println("Enter name of an employee");
			String first_name=sc.next();
			dataMap.put("first_name",first_name);
		}
		
		System.out.println("Do you know email id ?");
		System.out.println("1.YES 2.NO");
		choice=sc.nextInt();
		if(choice==1){
			System.out.println("Enter email id");
			String email_id=sc.next();
			dataMap.put("email_id", email_id);
		}
		
		Employee emp1=employeeServiceImpl.searchEmployee(dataMap);
		boolean flag=false;
		if(emp1!=null){
		 showInformation(emp1);
		 flag=true;
		}
		
		return flag;
			
	}
	
	public void getAllEmployee(){
		
		ArrayList<Employee> employees=employeeServiceImpl.getAllEmployee();
		
		for(Employee emp:employees){	
			System.out.println("Kin_Id: "+emp.getEmployee_id());
			System.out.println(" Name: "+emp.getName());
			System.out.println("Phone Number: "+emp.getPhone_number());
			System.out.println("Email Id: "+emp.getEmail_id());
			System.out.println("Address: "+emp.getAddress());
			System.out.println("Date of Birth: "+emp.getDate_of_birth());
			System.out.println("Date of Joining: "+emp.getDate_of_joining());
			System.out.println();
		}
			
	}
	
	public void showInformation(Employee emp){
		
		System.out.println("Kin_Id: "+emp.getEmployee_id());
		System.out.println("First Name: "+emp.getName());
		System.out.println("Phone Number: "+emp.getPhone_number());
		System.out.println("Email Id: "+emp.getEmail_id());
		System.out.println("Address: "+emp.getAddress());
		System.out.println("Date of Birth: "+emp.getDate_of_birth());
		System.out.println("Date of Joining: "+emp.getDate_of_joining());
		System.out.println();
		
	}
}
