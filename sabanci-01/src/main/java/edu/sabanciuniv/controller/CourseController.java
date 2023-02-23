package edu.sabanciuniv.controller;

import edu.sabanciuniv.service.CourseService;
import edu.sabanciuniv.model.Course;

import java.util.List;

public class CourseController {

    public CourseService service = new CourseService();

    public List<Course> findAllCourses() {
        return service.findAll();
    }

    public Course findCourse(int id) {
        return service.find(id);
    }

    public void saveCourse(Course course) {
        service.save(course);
    }

    public void deleteCourse(Course course) {
        service.delete(course);
    }


}
