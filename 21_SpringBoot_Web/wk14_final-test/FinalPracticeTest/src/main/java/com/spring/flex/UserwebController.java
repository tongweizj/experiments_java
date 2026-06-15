package com.spring.flex;
//Controller for Webflux Thymeleaf

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// add,delete,edit user
@Controller
public class UserwebController {

	private final UserRepository repository;

	public UserwebController(UserRepository repository) {
		this.repository = repository;
	}

	// Reactive - Webflux implementation (Mono<String>)
	@GetMapping("/")
	public Mono<String> home() {
		return Mono.just("index");
	}
	

	// 1. 用户列表
	@GetMapping("/show")
	public String users(final Model model) {
		// 关键点：Thymeleaf 3.0+ 支持直接在 Model 中处理 Flux
		// 它会自动订阅并以响应式方式渲染页面
		Flux<User> userFlux = repository.findAll();
		model.addAttribute("users", userFlux);

		return "show"; // 对应 templates/show.html
	}
	
	// 2. 用户详情
	@GetMapping("/show/{id}")
	public  String userDetail(@PathVariable String id, Model model) {
		
		Mono<User> userMono = repository.getUserById(id);
		model.addAttribute("user", userMono);

		return "userDetail"; 
	}

	// 3. 添加用户
	@GetMapping("/users/create")
	public String createUser(Model model) {
		model.addAttribute("user", new User());

		return "userForm";
	}
	
	// 编辑：从数据库获取现有对象
    @GetMapping("/users/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Mono<User> userMono = repository.getUserById(id);
        model.addAttribute("user", userMono);
        model.addAttribute("pageTitle", "编辑用户");
        return "userForm";
    }
    
	// 处理表单提交
    @PostMapping("/users/save")
    public Mono<String> saveUser(User user) {
    	// 如果 id 是空字符串，强制设为 null
        if ("".equals(user.getId())) {
            user.setId(null);
        }
        // 调用 repository 保存，然后重定向到详情页或列表页
        return repository.save(user)
                .map(u -> "redirect:/show");
    }
	// 4. 删除用户
	@GetMapping("/users/delete/{id}")
	public Mono<String> deleteUser(@PathVariable String id) {
	    // Call service to execute delete logic
	    return repository.deleteById(id)
	            .doOnSuccess(v -> System.out.println("User deleted: " + id))
	            .then(Mono.just("redirect:/show"));
	}
	
	@GetMapping("/search")
	public String searchUser(@RequestParam(required = false) String email, final Model model) {
		System.out.println(email);
		if (email != null && !email.isEmpty()) {
			// 直接传递 Mono 给 Model
			Mono<User> userMono = repository.findByEmail(email);
			model.addAttribute("user", userMono);
		}
		return "search"; // 对应 templates/search.html
	}
}