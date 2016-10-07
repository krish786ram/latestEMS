package com.flp.ems.domain;

import java.util.Date;

public class Employee {
	private String name;
	private String phone_number;
	private String address;
	private Date date_of_birth;
	private Date date_of_joining;
	private String employee_id;
	private String email_id;
	
	
	
	public Employee(String name, String phone_number, String address, Date date_of_birth,
			Date date_of_joining, String employee_id, String email_id) {
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
		this.employee_id = employee_id;
		this.email_id = email_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}

	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public Date getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public String getEmail_id() {
		return email_id;
	}
		
}

