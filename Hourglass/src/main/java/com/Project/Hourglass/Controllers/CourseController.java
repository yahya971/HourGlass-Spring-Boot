package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        return findCourseById(id);
    }


    private Course findCourseById(int id) {
        return  null;
    }
}
