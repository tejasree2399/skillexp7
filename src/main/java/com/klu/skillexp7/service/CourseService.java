package com.klu.skillexp7.service;

import java.util.List;

import com.klu.skillexp7.entity.Course;

public interface CourseService {

    Course addCourse(Course course);

    Course updateCourse(int id, Course course);

    String deleteCourse(int id);

    List<Course> getAllCourses();

    Course getCourseById(int id);

    List<Course> searchByTitle(String title);

}