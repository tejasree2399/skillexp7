package com.klu.skillexp7.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.skillexp7.entity.Course;
import com.klu.skillexp7.repository.CourseRepository;
import com.klu.skillexp7.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository repo;

    @Override
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        Course c = repo.findById(id).orElse(null);

        if(c!=null)
        {
            c.setTitle(course.getTitle());
            c.setDuration(course.getDuration());
            c.setFee(course.getFee());
            return repo.save(c);
        }
        return null;
    }

    @Override
    public String deleteCourse(int id) {
        repo.deleteById(id);
        return "Course Deleted Successfully";
    }

    @Override
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Course> searchByTitle(String title) {
        return repo.findByTitle(title);
    }

}