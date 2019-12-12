package com.Project.Hourglass.Controllers;

import com.Project.Hourglass.Repositories.CourseRepository;
import com.Project.Hourglass.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="course",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST,RequestMethod.PUT})
public class CourseController {

    @Autowired
    public CourseRepository courseRepo;
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseRepo.findById(id).get();
    }

    @GetMapping("")
    public List<Course> getAllCourse (){
        return courseRepo.findAll();
    }
    
    @PostMapping("/addCourse")
    public Course createOrSaveUser(@RequestBody Course newCourse) {
        return courseRepo.save(newCourse);
    }
    @DeleteMapping("/delCourse/{id}")
    void deleteCourse(@PathVariable Long id) {
        courseRepo.deleteById(id);
    }
    @PutMapping("/updateCourse/{id}")
    Course updatecourse(@RequestBody Course newcourse, @PathVariable Long id) {
        return courseRepo.findById(id).map(course -> {
            course.setName(newcourse.getName());
            course.setDescription(newcourse.getDescription());
            course.setPrice(newcourse.getPrice());
            return courseRepo.save(course);
        }).orElseGet(() -> {
            newcourse.setId(id);
            return courseRepo.save(newcourse);
        });
    }



}
