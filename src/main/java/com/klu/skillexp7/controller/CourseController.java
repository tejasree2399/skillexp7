package com.klu.skillexp7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.skillexp7.entity.Course;
import com.klu.skillexp7.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course)
    {
        Course c = service.addCourse(course);
        return new ResponseEntity<>(c,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses()
    {
        return new ResponseEntity<>(service.getAllCourses(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id)
    {
        Course c = service.getCourseById(id);

        if(c==null)
            return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,@RequestBody Course course)
    {
        Course c = service.updateCourse(id, course);

        if(c==null)
            return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id)
    {
        service.deleteCourse(id);
        return new ResponseEntity<>("Course Deleted",HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title)
    {
        return new ResponseEntity<>(service.searchByTitle(title),HttpStatus.OK);
    }
}