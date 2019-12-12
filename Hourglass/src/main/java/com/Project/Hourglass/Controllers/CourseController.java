package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.Repositories.CourseRepository;
import com.Project.Hourglass.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    public CourseRepository courseRepo;
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseRepo.findById(id).get();
    }

}
