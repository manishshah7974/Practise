package com.Work.SampleProject.Service;

import com.Work.SampleProject.Model.Course;
import com.Work.SampleProject.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        Course data = courseRepository.save(course);
        return data;
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public Course updateCourse(Course updateCourse) {

        return courseRepository.save(updateCourse);
    }

    public Course findCourseById(int id) {
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()) {
            // value is present inside Optional
            return optional.get();
        } else {
            return null;
        }
    }
}

