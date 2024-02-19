package com.miscroservice.courses.services;

import com.miscroservice.courses.client.StudentClient;
import com.miscroservice.courses.entities.Course;
import com.miscroservice.courses.entities.dtos.StudentDTO;
import com.miscroservice.courses.http.response.StudentByCourseResponse;
import com.miscroservice.courses.persistence.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ICoursesServicesImpl implements ICoursesServices{
    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private StudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return (List<Course>) coursesRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return coursesRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        coursesRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        Course course = coursesRepository.findById(idCourse).orElse(new Course());
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentsDTOList(studentDTOList)
                .build();
    }
}
