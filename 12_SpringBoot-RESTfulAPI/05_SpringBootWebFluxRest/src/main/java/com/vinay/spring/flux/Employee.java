package com.vinay.spring.flux;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Employee {
	//primary key field 
		@Id
		private int empId;
		private String empName;
		private String jobTitle;
		private double salary;
		
		public Employee()
		{
			
		}
		

		public Employee(int empId, String empName, String jobTitle, double salary) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.jobTitle = jobTitle;
			this.salary = salary;
		}
		
		//setter and getter methods
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
