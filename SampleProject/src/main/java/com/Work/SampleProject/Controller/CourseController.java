package com.Work.SampleProject.Controller;

import com.Work.SampleProject.Model.Course;
import com.Work.SampleProject.Repository.CourseRepository;
import com.Work.SampleProject.Service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/check")
    public String check() {
        return "home";
    }

    @RequestMapping("/getAllData")
    public List<Course> getAllData() {
        logger.info(" API Call Hit - /getAllData");
        logger.info("All Course List - {}", courseService.getAllCourse());
        return courseService.getAllCourse();
    }

    @PostMapping("/addCourse")
    Course newCourse(@RequestBody Course newCourse) {
        logger.info("API Call  - /addCourse ");
        logger.info("New Course Added {}", newCourse);

        return courseService.addCourse(newCourse);
    }

    @RequestMapping("/find/{id}")
    public Optional<Course> getAllData(@PathVariable int id) {
        logger.info(" API Call Hit - /find{}", id);
        logger.info("All Course List - {}", courseService.findCourseById(id));
        return Optional.ofNullable(courseService.findCourseById(id));
    }

    @PutMapping("/update/{id}")
    Course updateData(@RequestBody Course updatedCourse, @PathVariable int id) throws Exception {
        Course fromdb = courseService.findCourseById(id);
        if (fromdb != null) {
            fromdb.setCourse_list(updatedCourse.getCourse_list());
            return courseRepository.save(fromdb);
        } else {
            throw new Exception("Course Not Present In DataBase");

        }
    }
}