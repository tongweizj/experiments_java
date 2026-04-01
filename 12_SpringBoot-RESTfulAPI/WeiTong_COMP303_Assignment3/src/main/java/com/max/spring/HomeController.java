package com.max.spring;

/* Author: Wei Tong 301034450
 * COMP 303 - Enterprise App Development
 * Assign 3
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("apiName", "Restaurant Management API");
		model.addAttribute("version", "v1.0");
		return "index"; // 对应 templates/index.html
	}
}