package com.microservices.students.services;

import com.microservices.students.entities.Student;

import java.util.List;

public interface IStudentsServices {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    List<Student> findByIdCourse(Long idCourse);
}
