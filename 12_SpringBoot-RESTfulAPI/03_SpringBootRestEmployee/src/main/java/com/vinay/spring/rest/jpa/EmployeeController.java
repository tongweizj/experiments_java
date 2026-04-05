package com.vinay.spring.rest.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
    EmployeeRepository empRepository;

    // Get All Employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    // Add a new employee
    @PostMapping("/employee")
    public Employee addEmployee(@Validated @RequestBody Employee emp) {
    	// @Validated 的作用是告诉 Spring：
    	// 在把请求体（JSON）转换成 Java 对象后，立即检查该对象是否符合预设的校验规则。
        return empRepository.save(emp);
    }
}



