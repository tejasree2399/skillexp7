package com.klu.skillexp7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.skillexp7.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

    List<Course> findByTitle(String title);

}