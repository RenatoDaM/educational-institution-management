package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.CourseModel;
import com.educational.educationalinstitutionmanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseModel save(CourseModel course) {
        return courseRepository.save(course);
    }

    public Optional<CourseModel> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<CourseModel> findAll() {
        return courseRepository.findAll();
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseModel update(CourseModel course) {
        return courseRepository.save(course);
    }
}
