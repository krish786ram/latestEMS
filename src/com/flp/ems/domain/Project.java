package com.flp.ems.domain;

public class Project {
	private String project_id,department_id;
	private String project_name;
	
	public Project(String project_id, String project_name,String department_id) {
		this.project_id = project_id;
		this.project_name = project_name;
		this.department_id=department_id;
	}
	
	public String getProject_id() {
		return project_id;
	}
	
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	
	public String getProject_name() {
		return project_name;
	}
	
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
}
