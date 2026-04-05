package com.vinay.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
    EmployeeService empService;
	
	@ResponseBody
	@RequestMapping("/")
//	@GetMapping("/")
	public String home()
	{
		return "An Employee Web service created";
	}

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    Employee getEmployee(@PathVariable("empId") int empId) throws Exception {
        return empService.getEmployee(empId);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    // @GetMapping("/employees") 两个Annotation 等价
    Iterable<Employee> getEmployees() {
        return empService.getEmployees();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    // @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    // @PostMapping("/employee") 以上3个Annotation 等价
    @ResponseStatus(value = HttpStatus.OK)
    void addEmployee(@RequestBody Employee emp) throws Exception {
        empService.addEmployee(emp);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee emp) throws Exception {
        emp.setEmpId(empId);
        empService.updateEmployee(emp);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    // @ResponseStatus: 告诉 Spring，当这个方法执行完毕（没有抛出异常）时，发送给客户端的 HTTP 状态码是多少。
    // value = HttpStatus.OK: 具体的代码值。HttpStatus.OK 对应的数字就是 200。
    void deleteEmployee(@PathVariable("empId") int empId) throws Exception {
    	// @PathVariable: 告诉 Spring，“去 URL 路径里找一个变量”。
		// ("empId"): 这是指定要找的变量名称。
    	// 它必须和 @RequestMapping 或 @GetMapping 里的占位符名称{empId}完全一致。
		// int empId: 这是接收变量的 Java 变量类型和名称。
        empService.deleteEmployee(empId);
    }
	
	

}
