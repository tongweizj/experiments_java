package com.spring.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class VehicleWebController {

	private final VehicleRepository repository;

	public VehicleWebController(VehicleRepository repository) {
		this.repository = repository;
	}

	// Reactive - Webflux implementation (Mono<String>)
	@GetMapping("/")
	public Mono<String> home() {
		return Mono.just("index");
	}
	

	// 1. 用户列表
	@GetMapping("/vehicles")
	public String vehicles(final Model model) {
		// 关键点：Thymeleaf 3.0+ 支持直接在 Model 中处理 Flux
		// 它会自动订阅并以响应式方式渲染页面
		Flux<Vehicle> vehicleFlux = repository.findAll();
		model.addAttribute("vehicles", vehicleFlux);

		return "vehicles"; // 对应 templates/show.html
	}
	

	// 3. 添加用户
	@GetMapping("/vehicles/create")
	public String createVehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "vehicleForm";
	}
	

    
	// 处理表单提交
    @PostMapping("/vehicles/save")
    public Mono<String> saveVehicle(Vehicle vehicle) {
    	// 如果 id 是空字符串，强制设为 null
        if ("".equals(vehicle.getId())) {
            vehicle.setId(null);
        }
        // 调用 repository 保存，然后重定向到详情页或列表页
        return repository.save(vehicle)
                .map(u -> "redirect:/vehicles");
    }

	
	@GetMapping("/search")
	public String searchVehicle(@RequestParam(required = false) String year, final Model model) {
		System.out.println(year);
		if (year != null && !year.isEmpty()) {
			// 直接传递 Mono 给 Model
			int yearNumber = Integer.parseInt(year);
			Flux<Vehicle> vehicleFlux = repository.findByYear(yearNumber);
			model.addAttribute("vehicles", vehicleFlux);
		}
		return "search"; // 对应 templates/search.html
	}
}
