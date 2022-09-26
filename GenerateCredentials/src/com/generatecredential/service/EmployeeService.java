package com.generatecredential.service;

import com.generatecredential.model.Employee;

public class EmployeeService {
	
	public void generateEmailAddress(Employee employee) {
		String emailAddress = CredentialService.generateEmailAddress(employee.getFirst_Name(), employee.getLast_Name(), employee.getDept());
		employee.setEmailAddress(emailAddress);
	}
	
	public Employee saveCredentials(int length, Employee employee) {
		String password = CredentialService.generatePassword(length);
		employee.setPassword(password);
		return employee;
	}
	
	public void printEmployeeDetails(Employee employee) {
		CredentialService.showCredentials(employee);
	}

}
