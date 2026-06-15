package com.spring.vehicle;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	private final VehicleRepository repository;
	public VehicleController(VehicleRepository repository) {
		this.repository = repository;
	}
	
	// Get All
	@GetMapping
	public Flux<Vehicle> getAllVehicles() {
		return repository.findAll();
	}
	
	// Update the user
	@PutMapping("/{id}")
	public Mono<Vehicle> updateVehicle(@PathVariable String id, @RequestBody Vehicle updatedVehicle) {
		return repository.findById(id).flatMap(existingVehicle -> {
			existingVehicle.setBrand(updatedVehicle.getBrand()); // 假设 User 有这些字段
			existingVehicle.setAddedDate(updatedVehicle.getAddedDate());
			return repository.save(existingVehicle);
		});
	}

	// Delete user
//	@DeleteMapping("/{vinNumber}")
//	public String deleteVehicle(@PathVariable String vinNumber) {
//		repository.deleteByVinNumber(vinNumber);
//		return "ok";
//	}
	
	@DeleteMapping("/{vinNumber}")
	public Mono<String> deleteVehicle(@PathVariable String vinNumber) {
	    // 1. 首先尝试根据 VIN 找到该车辆
	    return repository.findByVinNumber(vinNumber)
	        // 2. 如果找到了，进行删除操作
	        .flatMap(existingVehicle -> 
	            repository.deleteByVinNumber(vinNumber)
	                .thenReturn("Deleted!") // 删除成功后返回指定消息
	        )
	        // 3. 如果 findByVinNumber 返回空（即不存在），则执行这里
	        .defaultIfEmpty("Vehicle does not exist");
	}
}
