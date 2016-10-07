package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.AutoGenerate;
import com.flp.ems.util.DBConnection;

public class EmployeeDaoImplForDB implements IemployeeDao{
	 
	DBConnection dbcon=new DBConnection();
	AutoGenerate generate=new AutoGenerate();
	
	@Override
	public void addEmployee(HashMap<String,String> dataMap) {
		try {
			
			String departmentID=dataMap.get("department_id");
			String department_name=dataMap.get("department_name");
			int department_id=Integer.parseInt(departmentID);
			
			String roleID=dataMap.get("role_id");
			String role_name=dataMap.get("role_name");
			int role_id=Integer.parseInt(roleID);
			
			String projectID=dataMap.get("project_id");
			String project_name=dataMap.get("project_name");
			int project_id=Integer.parseInt(projectID);
			
			String name=dataMap.get("name");
			String phonenumber=dataMap.get("phone_number");
			String address=dataMap.get("address");
			String date_of_birth=dataMap.get("date_of_birth");
			String date_of_joining=dataMap.get("date_of_joining");
			String email_id=generate.autoGenerateEmailId(name);
						
			int phone_number=Integer.parseInt(phonenumber);
			
			Date dob = null,doj = null;
			String format="dd-mm-yyyy";
			SimpleDateFormat dformat = new SimpleDateFormat(format);
			
			try {
				dob=(Date) dformat.parse(date_of_birth);
				doj=(Date) dformat.parse(date_of_joining);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			java.sql.Date sqldob=new java.sql.Date(dob.getTime());
			java.sql.Date sqldoj=new java.sql.Date(doj.getTime());
			
			Connection con=dbcon.getConnection();
			
			PreparedStatement stmt=null;
			
			Properties props=new Properties();
			FileInputStream fIn=new FileInputStream("dbDetails.properties");		
			props.load(fIn);
			
			String insertDepartmentQuery=props.getProperty("jdbc.query.insertDepartment");
			
			stmt=con.prepareStatement(insertDepartmentQuery);
			
			stmt.setInt(1,department_id);
			stmt.setString(2, department_name);
			
			stmt.executeUpdate();
			
			String insertRoleQuery=props.getProperty("jdbc.query.insertRole");
			
			stmt=con.prepareStatement(insertRoleQuery);
			
			stmt.setInt(1,role_id);
			stmt.setString(2,role_name);
			
			stmt.executeUpdate();
			
			String insertProjectQuery=props.getProperty("jdbc.query.insertProject");
			
			stmt=con.prepareStatement(insertProjectQuery);
			
			stmt.setInt(1,project_id);
			stmt.setString(2,project_name);
			stmt.setInt(3,department_id);
			
			stmt.executeUpdate();
			
			String insertEmployeeQuery=props.getProperty("jdbc.query.insertEmployee");
			
			stmt=con.prepareStatement(insertEmployeeQuery);
			
			stmt.setString(2,name);
			stmt.setString(3,email_id);
			stmt.setInt(4,phone_number);
			stmt.setDate(5, dob);
			stmt.setDate(6, doj);
			stmt.setString(7,address);
			stmt.setInt(8,department_id);
			stmt.setInt(9,project_id);
			stmt.setInt(10,role_id);
			
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyEmployee(HashMap<String, String> dataMap) {
		
		try {
			Connection con=dbcon.getConnection();
			Properties props=new Properties();
			FileInputStream fIn=new FileInputStream("dbDetails.properties");		
			props.load(fIn);
			
			String emp_id=dataMap.get("employee_id");
			Integer employee_id=Integer.parseInt(emp_id);
			
			PreparedStatement stmt;
			
			if(dataMap.containsKey("name")){
				String updateEmployeeName=props.getProperty("jdbc.query.updateEmployeeName");
				
				stmt=con.prepareStatement(updateEmployeeName);
				
				stmt.setString(2, dataMap.get("name"));
				
				stmt.executeUpdate();
			}
			
			if(dataMap.containsKey("phone_number")){
				String updateEmployeePhoneNumber=props.getProperty("jdbc.query.updateEmployeePhoneNumber");
				
				stmt=con.prepareStatement(updateEmployeePhoneNumber);
				
				Integer phone_no=Integer.parseInt(dataMap.get("phone_number"));
				
				stmt.setInt(4,phone_no);
				
				stmt.executeUpdate();
			}
			
			if(dataMap.containsKey("address")){
				String updateEmployeeAddress=props.getProperty("jdbc.query.updateEmployeeAddress");
				
				stmt=con.prepareStatement(updateEmployeeAddress);
				
				stmt.setString(7, dataMap.get("address"));
				
				stmt.executeUpdate();
			}
			
			con.close();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployee(String emp_id) {
		int employee_id=Integer.parseInt(emp_id);
		
		try {
			Connection con=dbcon.getConnection();
			Properties props=new Properties();
			FileInputStream fIn=new FileInputStream("dbDetails.properties");		
			props.load(fIn);
			
			String removeEmployeeQuery=props.getProperty("jdbc.query.removeEmployee");
			
			PreparedStatement stmt=con.prepareStatement(removeEmployeeQuery);
			
			stmt.setInt(1,employee_id);
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee searchEmployee(HashMap<String, String> dataMap) {
		Employee temp_emp=null;
		try {
			Connection con=dbcon.getConnection();
			Properties props=new Properties();
			FileInputStream fIn=new FileInputStream("dbDetails.properties");		
			props.load(fIn);
			
			if(dataMap.containsKey("employee_id")){
				
			String findEmployeeByEmployeeID=props.getProperty("jdbc.query.findEmployeeByEmployeeID");
			PreparedStatement stmt=con.prepareStatement(findEmployeeByEmployeeID);
			
			stmt.setInt(1,Integer.parseInt(dataMap.get("employee_id")));
			
			ResultSet result=stmt.executeQuery();
			
			while(result.next()){
				String name=result.getString("name");
				int phone_no=result.getInt("phone_number");
				String address=result.getString("address");
				Date date_of_birth=result.getDate("date_of_birth");
				Date date_of_joining=result.getDate("date_of_joining");
				int emp_id=result.getInt("Employee_id");
				String email_id=result.getString("email_id");
				
				String phone_number=Integer.toString(phone_no);
				String employee_id=Integer.toString(emp_id);
				
			 temp_emp=new Employee(name,phone_number,address,date_of_birth,date_of_joining,employee_id,email_id);	
			}
			}
			
			else if(dataMap.containsKey("email_id")){
				
				String findEmployeeByEmailID=props.getProperty("jdbc.query.findEmployeeByEmailID");
				PreparedStatement stmt=con.prepareStatement(findEmployeeByEmailID);
				
				stmt.setString(3,dataMap.get("email_id"));
				
				ResultSet result=stmt.executeQuery();
				
				while(result.next()){
					String name=result.getString("name");
					int phone_no=result.getInt("phone_number");
					String address=result.getString("address");
					Date date_of_birth=result.getDate("date_of_birth");
					Date date_of_joining=result.getDate("date_of_joining");
					int emp_id=result.getInt("Employee_id");
					String email_id=result.getString("email_id");
					
					String phone_number=Integer.toString(phone_no);
					String employee_id=Integer.toString(emp_id);
					
				 temp_emp=new Employee(name,phone_number,address,date_of_birth,date_of_joining,employee_id,email_id);	
				}
				}
			
			else if(dataMap.containsKey("name")){
				
				String findEmployeeByName=props.getProperty("jdbc.query.findEmployeeByName");
				PreparedStatement stmt=con.prepareStatement(findEmployeeByName);
				
				stmt.setString(2,dataMap.get("name"));
				
				ResultSet result=stmt.executeQuery();
				
				while(result.next()){
					String name=result.getString("name");
					int phone_no=result.getInt("phone_number");
					String address=result.getString("address");
					Date date_of_birth=result.getDate("date_of_birth");
					Date date_of_joining=result.getDate("date_of_joining");
					int emp_id=result.getInt("Employee_id");
					String email_id=result.getString("email_id");
					
					String phone_number=Integer.toString(phone_no);
					String employee_id=Integer.toString(emp_id);
					
				 temp_emp=new Employee(name,phone_number,address,date_of_birth,date_of_joining,employee_id,email_id);	
				}
				}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return temp_emp;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		ArrayList<Employee> employees=new ArrayList<>();
		
		try {
			Connection con=dbcon.getConnection();
			Properties props=new Properties();
			FileInputStream fIn=new FileInputStream("dbDetails.properties");		
			props.load(fIn);
			
			Statement stmt=(Statement) dbcon.getConnection();
			String selectAllQuery=props.getProperty("jdbc.query.selectEmployees");
			ResultSet result = stmt.executeQuery(selectAllQuery);
			
			while(result.next()){
				String name=result.getString("name");
				int phone_no=result.getInt("phone_number");
				String address=result.getString("address");
				Date date_of_birth=result.getDate("date_of_birth");
				Date date_of_joining=result.getDate("date_of_joining");
				int emp_id=result.getInt("Employee_id");
				String email_id=result.getString("email_id");
				
				String phone_number=Integer.toString(phone_no);
				String employee_id=Integer.toString(emp_id);
			
				
				Employee emp=new Employee(name,phone_number,address,date_of_birth,date_of_joining,employee_id,email_id);
				employees.add(emp);
			
			}
			
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return employees;
	}
	
}
