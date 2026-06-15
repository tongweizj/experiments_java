package com.max.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;
 
@Controller
@AllArgsConstructor
public class EmployeeController {
 
	@Autowired
	EmployeeRepository empRepo;
 
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }
 
   
    @RequestMapping("/display")
    public String show(final Model model) {
       model.addAttribute("employees", empRepo.findAll());
       return "employeeinfo";
 
    }
 
    
    @RequestMapping("/create")
	public String add()
	{
		return "add";
	}
 
   
    @RequestMapping("/insert")
    public String save(final Model model, final Employee employee) {  
    	empRepo.save(employee);
        model.addAttribute("employees", employee); 
        return "index";
    }
 
 }
