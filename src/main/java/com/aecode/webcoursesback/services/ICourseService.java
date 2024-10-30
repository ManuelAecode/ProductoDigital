package com.aecode.webcoursesback.services;

import com.aecode.webcoursesback.entities.Course;

import java.util.List;

public interface ICourseService {
    public void insert(Course course);
    List<Course> list();
    public void delete(int courseId);
    public Course listId(int courseId);
}
