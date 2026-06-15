package com.max.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
 
@RequestMapping("employee")
@AllArgsConstructor
@RestController
public class EmployeeController {
 
      @Autowired
      private EmployeeService empService;
 
      @GetMapping
      public Flux<Employee> getAll() {
            System.out.println("All the employee information");
            return empService.getAll();
      }
 
     
      @GetMapping("{id}")
      public Mono<Employee> getById(@PathVariable("id") final String id) {
            System.out.println("One employee information based for the given ID");
            return empService.getById(id);
      }
 
 
      @PutMapping("{id}")
      public Mono updateById(@PathVariable("id") final String id, @RequestBody final Employee employee) {
            System.out.println("Updating an employee Info");
            return empService.update(id, employee);
      }
 
      @PostMapping
      public Mono save(@RequestBody final Employee employee) {
            System.out.println("Added employee Info "+ employee.getEmpId() + " - " + employee.getEmpName()
            + " - " + employee.getJobTitle() + " - " + employee.getSalary());
            return empService.save(employee);
      }
 
      @DeleteMapping("{id}")
      public Mono delete(@PathVariable final String id) {
            System.out.println("An employee Info deleted");
            return empService.delete(id);
      }
}
