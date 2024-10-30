package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.Course;
import com.aecode.webcoursesback.repositories.ICourseRepo;
import com.aecode.webcoursesback.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements ICourseService {
    @Autowired
    private ICourseRepo cR;

    @Override
    public void insert(Course course) {
        cR.save(course);
    }

    @Override
    public List<Course> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int courseId) {
        cR.deleteById(courseId);
    }

    @Override
    public Course listId(int courseId) {
        return cR.findById(courseId).orElse(new Course());
    }
}
