package com.microservices.students.persistence;

import com.microservices.students.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByCourseId(Long courseId);
}
