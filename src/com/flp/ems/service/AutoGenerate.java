package com.flp.ems.service;

public class AutoGenerate {
	public static int employee_id=0;
	
	public String autogenerateID(){
		employee_id+=1;
		return  Integer.toString(employee_id);
	}
	
	public String autoGenerateEmailId(String name){
		String email_id = new String(name+"."+employee_id+"@barclays.com");	
		return email_id;
	}
}
