package com.generatecredential.service;

import java.util.Random;
import com.generatecredential.model.Employee;

public class CredentialService {
	
		private static final String DOMAIN = "example.com"; 
		private static final String DELIMITER = ""; // delimiter to change the email patters for future use 
		private static final String[] PASSWORD_CASE = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ","abcdefghijklmopqrstuvwxyz","0123456789","~!@#$%^&*(/)_+\',.<>=-"}; // array of strings consisting uppercase, lowercase, numbers and special chars

		
		
		public static String generatePassword(int length) {
			
			String password = ""; // initializing password as empty string
			
			Random random = new Random(); 
			
			int i = 0; 
			
			while(password.length()<length) { // while loops begins with the condition to check if the password length is less than the length passed
				
				if(i>PASSWORD_CASE.length-1) // if iterator greater than array length then i = 0;
					i=0;
				
				password += PASSWORD_CASE[i].charAt(random.nextInt(PASSWORD_CASE[i].length())); // appending all the types of chars in loop to string password
				
				i++;
			}
			return password; 
		}
		
		
		public static String generateEmailAddress(String first_Name, String last_Name, String department) {
			
			String email = first_Name+DELIMITER+ last_Name+"@"+department+"."+DOMAIN;
			
			return email;
			
		}
		public static void showCredentials(Employee employee) {

			System.out.println("----------------------------------------------------------");
			System.out.println("Dear "+employee.getFirst_Name()+" your generated credentials are as follows");
			System.out.println();
			System.out.println("Email Address ------> " + employee.getEmailAddress());
			System.out.println("Password      ------> " + employee.getPassword());
			System.out.println("--------------------Additional Details--------------------");
			System.out.println();
			System.out.println("Address       ------> " + employee.getAddress());
			System.out.println("Phone Number  ------> " + employee.getPhoneNumber());
		}

		}
		
		


