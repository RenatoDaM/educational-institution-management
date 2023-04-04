package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.CourseHistoryModel;
import com.educational.educationalinstitutionmanagement.repository.CourseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseHistoryService {
    @Autowired
    private CourseHistoryRepository courseHistoryRepository;

    public CourseHistoryModel save(CourseHistoryModel courseHistory) {
        return courseHistoryRepository.save(courseHistory);
    }

    public Optional<CourseHistoryModel> findById(Long id) {
        return courseHistoryRepository.findById(id);
    }

    public List<CourseHistoryModel> findAll() {
        return courseHistoryRepository.findAll();
    }

    public void deleteById(Long id) {
        courseHistoryRepository.deleteById(id);
    }

    public CourseHistoryModel update(CourseHistoryModel courseHistory) {
        return courseHistoryRepository.save(courseHistory);
    }
}
