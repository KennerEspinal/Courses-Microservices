package com.microservices.students.controller;

import com.microservices.students.entities.Student;
import com.microservices.students.services.IStudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentsServices studentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }
    @GetMapping("search-in-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long IdCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(IdCourse));
    }
}
