package com.vinay.web.flux;

/* Author: Vinay
 * COMP 303 - Enterprise App Development
 * Lab 9 Demo -  Creating a Spring Boot Flux app with MongoDB
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
