package com.miscroservice.courses.client;

import com.miscroservice.courses.entities.dtos.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mcsv-student", url = "http://localhost:8080/api/students")
public interface StudentClient {

    @GetMapping("search-in-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long IdCourse);

}
