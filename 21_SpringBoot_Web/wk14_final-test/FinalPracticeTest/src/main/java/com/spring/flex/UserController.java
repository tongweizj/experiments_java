package com.spring.flex; // 请确保包名与你的目录结构一致

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserRepository repository;

	// 显式构造函数注入
	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	// Get All
	@GetMapping
	public Flux<User> getAllUsers() {
		return repository.findAll();
	}

	// Get by ID
	@GetMapping("/{id}")
	public Mono<User> getUser(@PathVariable String id) {
		return repository.findById(id);
	}

	// Add a new user
	@PostMapping
	public Mono<User> createUser(@RequestBody User user) {
		return repository.save(user);
	}

	// Update the user
	@PutMapping("/{id}")
	public Mono<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
		return repository.findById(id).flatMap(existingUser -> {
			existingUser.setName(updatedUser.getName()); // 假设 User 有这些字段
			existingUser.setEmail(updatedUser.getEmail());
			return repository.save(existingUser);
		});
	}

	// Delete user
	@DeleteMapping("/{id}")
	public Mono<Void> deleteUser(@PathVariable String id) {
		return repository.deleteById(id);
	}

	// Search a user by email
	@GetMapping("/users/search")
	public Mono<User> searchByEmail(@RequestParam String email) {
		return repository.findByEmail(email);
	}
}