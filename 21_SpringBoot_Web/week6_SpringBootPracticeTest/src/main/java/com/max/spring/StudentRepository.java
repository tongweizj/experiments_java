package com.max.spring;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Wei Tong
 * COMP 303 - Enterprise App Development
 * Midterm Practice Test
 * Spring Boot Web MVC Application with MySQL
 *  
 * Spring Boot Web MVC Application with MySQL
 * Repository interface for Student entity.
 * Inherits from JpaRepository to provide standard CRUD operations 
 * (save, findById, findAll, delete, etc.) without manual implementation.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Derived query method to find students by their academic program.
     * Spring Data JPA automatically generates the SQL "SELECT * FROM student WHERE program_name = ?"
     * * @param programName The name of the program to search for.
     * @return A list of Student objects matching the criteria.
     */
    List<Student> findByProgramName(String programName);
}