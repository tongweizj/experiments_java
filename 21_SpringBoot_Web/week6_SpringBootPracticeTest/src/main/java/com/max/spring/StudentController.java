package com.max.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: Wei Tong
 * COMP 303 - Enterprise App Development
 * Midterm Practice Test
 * Spring Boot Web MVC Application with MySQL
 * 
 * Spring Boot Web MVC Application with MySQL
 * Controller class to handle all web requests related to Student management.
 * Implements CRUD operations, searching, and statistical aggregation.
 */
@Controller
public class StudentController {

    /**
     * Dependency injection of the StudentRepository to perform DB operations.
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Displays the home page with a list of students.
     * Supports optional filtering by program name via request parameters.
     * * @param program The program name to filter by (optional).
     * @param model   The UI model to pass data to Thymeleaf.
     * @return The index view name.
     */
    @GetMapping("/")
    public String viewStudents(@RequestParam(value = "program", required = false) String program, Model model) {
        List<Student> students;
        
        // Filter students if a program name is provided; otherwise, retrieve all records.
        if (program != null && !program.isEmpty()) {
            students = studentRepository.findByProgramName(program);
        } else {
            students = studentRepository.findAll();
        }
        
        // selectedProgram is passed back to keep the search input populated in the UI.
        String currentProgram = (program != null) ? program : "";
        model.addAttribute("selectedProgram", currentProgram);
        model.addAttribute("students", students);
        
        return "index";
    }

    /**
     * Renders the form for adding a new student.
     * Passes a blank Student object for Thymeleaf form-binding (th:object).
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student()); 
        return "add"; 
    }

    /**
     * Processes the submission of the new student form.
     * * @param student The student object bound from the form.
     * @param result  Captures validation errors based on Student model annotations.
     * @return Redirects to home on success, or stays on "add" page if validation fails.
     */
    @PostMapping("/add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        // Server-side validation check.
        if (result.hasErrors()) {
            return "add"; 
        }
        
        studentRepository.save(student);
        return "redirect:/";
    }

    /**
     * Retrieves a specific student by their ID to populate the edit form.
     * * @param no The unique student number from the URL path.
     * @throws IllegalArgumentException if the student ID does not exist in DB.
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long no, Model model) {
        Student student = studentRepository.findById(no)
            .orElseThrow(() -> new IllegalArgumentException("Invalid student number:" + no));
        
        model.addAttribute("student", student);
        return "edit"; 
    }

    /**
     * Updates an existing student record.
     * Ensures the ID is maintained to perform an UPDATE rather than an INSERT.
     */
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long no, @Valid Student student,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setNumber(no); // Maintain ID to keep form context.
            return "edit"; 
        }
       
        studentRepository.save(student);
        return "redirect:/";
    }

    /**
     * Deletes a student record based on the ID provided in the path.
     * Performs a find-before-delete check for safety.
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long no, Model model) {
        Student student = studentRepository.findById(no)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Student Number:" + no));
        
        studentRepository.delete(student);
        return "redirect:/";
    }

    /**
     * Aggregates student data to count occurrences of each academic program.
     * Uses a Map to store unique program names as keys and counts as values.
     * * @return The programs statistical view.
     */
    @GetMapping("/programs")
    public String viewPrograms(Model model) {
        List<Student> students = studentRepository.findAll();
        Map<String, Integer> programCounts = new HashMap<>();
        
        // Iterating through all students to count program distributions.
        for (Student s : students) {
            String pName = s.getProgramName();
            if (pName != null) {
                // Increment count if program exists, else initialize with 1.
                programCounts.put(pName, programCounts.getOrDefault(pName, 0) + 1);
            }
        }

        model.addAttribute("programMap", programCounts);
        return "programs";
    }
}