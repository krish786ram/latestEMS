package com.flp.ems.view;

import java.util.HashMap;
import java.util.Scanner;

public class BootClass {
	public static void main(String[] args) {
			menuSelection();
	}
	
	public static void menuSelection(){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Employee Management System");
		int choice=0;
		while(choice!=6){
		System.out.println("Enter 1 to add a Employee");
		System.out.println("Enter 2 to modify a Employee");
		System.out.println("Enter 3 to remove a Employee");
		System.out.println("Enter 4 to search a Employee");
		System.out.println("Enter 5 to get all Employees");
		System.out.println("Enter 6 to exit");
		
		choice=sc.nextInt();
		
		UserInteraction ui=new UserInteraction();
		
		switch(choice){
			case 1 :{
				System.out.println("Adding an employee");
				ui.addEmployee();
				break;
			}
			case 2 :{
				ui.modifyEmployee();
				break;
			}
			case 3 :{
				ui.removeEmployee();
				break;
			}
			case 4 :{
				boolean flag=ui.searchEmployee();
				if(flag)
					System.out.println("Searched Successfully");
				else
					System.out.println("Employee not found ");
				break;
			}
			case 5 :{
				System.out.println("Information of all Employees: ");
				ui.getAllEmployee();	
				break;
			}
			case 6:{
				System.out.println("Exited");
				break;
			}
			default: 
				System.out.println("Enter correct choice");
			}
		}
	}
}