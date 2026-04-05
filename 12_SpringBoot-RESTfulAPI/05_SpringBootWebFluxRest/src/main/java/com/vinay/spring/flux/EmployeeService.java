package com.vinay.spring.flux;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	public Flux<Employee> getAll() {
		return empRepository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Employee> getById(final int id) {
		return empRepository.findById(id);
	}

	public Mono update(final int id, final Employee employee) {
		return empRepository.save(employee);
	}

	public Mono save(final Employee employee) {
		return empRepository.save(employee);
	}
	
	public Mono<Employee> delete(final int id) {
		final Mono<Employee> dbEmployee = getById(id);
		if (Objects.isNull(dbEmployee)) {
			return Mono.empty();
		}
		return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(employeeToBeDeleted -> empRepository
				.delete(employeeToBeDeleted).then(Mono.just(employeeToBeDeleted)));
	}
	
	

}
