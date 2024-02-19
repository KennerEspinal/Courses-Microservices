package com.miscroservice.courses.services;

import com.miscroservice.courses.entities.Course;
import com.miscroservice.courses.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICoursesServices {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
