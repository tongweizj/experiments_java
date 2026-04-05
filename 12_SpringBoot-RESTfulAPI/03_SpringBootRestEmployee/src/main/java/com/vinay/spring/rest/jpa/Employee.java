package com.vinay.spring.rest.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="empid")
	private int empId;
	@Column(name="empname")
	private String empName;
	@Column(name="jobtitle")
	private String jobTitle;
	private double salary;
	@Column(name="deptno")
	private int deptNo;
	
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, String jobTitle, double salary, int deptNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.deptNo=deptNo;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo=deptNo;
	}

}
