package com.spring.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	// Index
	@GetMapping("/")
	public String index() {
		return "index";
	}

	// registration page
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}

	// registration validation and action
	@PostMapping("/register")
	public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		customerRepository.save(customer);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam String username, @RequestParam String password,Model model, HttpSession session) {
		// 1. get customer from database
		Customer customer = customerRepository.findByUsername(username);

		// 2. password validation
		if (customer != null && customer.getPassword().equals(password)) {
			// 把客户信息带到下个页面
			session.setAttribute("loggedInUser", customer); 
			// login, go to cruise page
			return "redirect:/bookings";
		} else {
			// login fails
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    // 1. 使当前 Session 失效（销毁所有存储的属性，如 loggedInUser）
	    session.invalidate();
	    
	    // 2. 重定向到首页或登录页
	    return "redirect:/?logout=success";
	}
	// show customer page
	@GetMapping("/profile")
	public String showProfile(HttpSession session, Model model) {
		// 1. 获取登录用户
	    Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
	    if (loggedInUser == null) return "redirect:/login";
	    
	 // 2. 将用户信息传给表单
	    model.addAttribute("customer", loggedInUser);
		return "profile";
	}
	
	@PostMapping("/profile/update")
	public String updateProfile(@ModelAttribute("customer") Customer customer, HttpSession session) {
	    // 1. 保存到数据库
	    customerRepository.save(customer);
	    
	    // 2. 重要：更新 Session 里的用户信息，否则导航栏显示的名字不会变
	    session.setAttribute("loggedInUser", customer);
	    
	    return "redirect:/bookings";
	}
}