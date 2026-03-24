package com.spring.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CruiseController {

    @Autowired
    private CruiseRepository cruiseRepository;

    //show all cruises
    @GetMapping("/cruises")
    public String listCruises(Model model) {
        model.addAttribute("cruises", cruiseRepository.findAll());
        return "cruises";
    }
}