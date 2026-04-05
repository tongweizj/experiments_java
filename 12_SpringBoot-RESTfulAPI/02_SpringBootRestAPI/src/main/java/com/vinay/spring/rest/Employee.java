package com.vinay.spring.rest;

import org.springframework.stereotype.Component;

//@Component
public class Employee {
	
	private int empId;
	private String empName;
	private String jobTitle;
	private double salary;
	
	
	public Employee(int empId, String empName, String jobTitle, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int id) {
		this.empId = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String name) {
		this.empName = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String job) {
		this.jobTitle = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double sal) {
		this.salary = sal;
	}

}
