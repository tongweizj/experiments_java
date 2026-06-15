package com.max.spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Author: Wei Tong
 * COMP 303 - Enterprise App Development
 * Midterm Practice Test
 * Spring Boot Web MVC Application with MySQL
 *
 * Student Entity class mapped to the database table.
 * Demonstrates the use of JPA annotations for persistence 
 * and Bean Validation annotations for server-side data integrity.
 */
@Entity
public class Student {

    /**
     * Primary key for the Student table.
     * Uses IDENTITY strategy for auto-incrementing the student number in MySQL.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    /**
     * Student's full name.
     * @NotBlank ensures the field is not null and contains at least one non-whitespace character.
     * @Size enforces character length constraints as per requirements.
     */
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
    private String name;

    /**
     * Academic program name.
     * Mandatory field for student registration.
     */
    @NotBlank(message = "Program name is required")
    private String programName;

    /**
     * Student's email address.
     * @Email validates the string follows a standard email format.
     * @NotEmpty ensures the field is not left blank.
     */
    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Email is required")
    private String email;

    // --- Getters and Setters ---

    public Long getNumber() { 
        return number; 
    }
    
    public void setNumber(Long number) { 
        this.number = number; 
    }

    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }

    public String getProgramName() { 
        return programName; 
    }
    
    public void setProgramName(String programName) { 
        this.programName = programName; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
}