package com.generatecredential.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.generatecredential.model.Employee;
import com.generatecredential.service.CredentialService;
import com.generatecredential.service.EmployeeService;

public class EmailClient {

	static EmployeeService es = new EmployeeService();
	
	public static int userInputs() {		
		Scanner opt = new Scanner(System.in); 		
		int num;
			while (!opt.hasNextInt()) { 				
				opt.next();
				System.out.println("Please enter numericals \n");				
			}
			num = opt.nextInt();			
			return num;		
	}

	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("Credential Generation");
		System.out.println();		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your First Name");
		String fName = sc.next();	
		
		System.out.println("Please enter your Lirst Name");
		String lName = sc.next();			
		
		System.out.println("Enter your department");		
		System.out.println("1. Technical \n2. Admin \n3. Human Resouce \n4. Legal");		
		int deptOpt = userInputs();

		while (deptOpt < 0 || deptOpt > 4) { // checking if user input is a number
			
			System.out.print("Please enter your option between 1 and 4 \n");
			deptOpt = userInputs();		
	}
		String dept = "";
		switch (deptOpt) {
		case 1:
			dept = "tech";
			break;
		case 2:
			dept = "admin";
			break;
		case 3:
			dept = "hr";
			break;
		case 4:
			dept = "legal";
			break;
		}
		Employee emp = new Employee(fName, lName);
		emp.setDept(dept);		
		es.generateEmailAddress(emp);
		System.out.println("Enter your address");
		String address = sc.next();
		emp.setAddress(address);
		System.out.println("Enter your phone number");		
		String phoneNumber = sc.next();
		emp.setPhoneNumber(phoneNumber);
		es.saveCredentials(8, emp);
		es.printEmployeeDetails(emp);
		sc.close();

	}
		
	

}
