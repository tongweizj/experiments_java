package com.vinay.web.flux;

/* Author: Vinay
 * COMP 303 - Enterprise App Development
 * Lab 9 Demo -  Creating a Spring Boot Flux app with MongoDB
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
