package com.vinay.spring.rest;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	Map<Integer, Employee> employee = new HashMap<>();

    public void addEmployee(Employee emp) throws Exception {
        if(employee.containsKey(emp.getEmpId())) {
            throw new Exception("This employee Id already exists");
        }
        else {
            employee.put(emp.getEmpId(), emp);
        }
    }

    public Iterable<Employee> getEmployees(){
        return employee.values();
    }

    public Employee getEmployee(int empId) throws Exception {

        if(employee.containsKey(empId)) {
            return employee.get(empId);
        }
        else {
            throw new Exception("Employee Id not found");
        }
    }

    public void updateEmployee(Employee emp) throws Exception {
        if(employee.containsKey(emp.getEmpId())) {
            employee.put(emp.getEmpId(), emp);
        }
        else {
            throw new Exception("Employee Id not found");
        }
    }

    public void deleteEmployee(int empId) throws Exception {
        if(employee.containsKey(empId)) {
            employee.remove(empId);
        }
        else {
            throw new Exception("Enployee Id not found");
        }
    }

}
