package com.microservices.students.services;

import com.microservices.students.entities.Student;
import com.microservices.students.persistence.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentsServicesImpl implements IStudentsServices{
    @Autowired
    private StudentsRepository studentsRepository;
    @Override
    public List<Student> findAll() {
        return (List<Student>) studentsRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentsRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentsRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentsRepository.findAllByCourseId(idCourse);
    }
}
