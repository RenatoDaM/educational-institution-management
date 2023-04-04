package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EnrollmentModel;
import com.educational.educationalinstitutionmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentModel save(EnrollmentModel enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Optional<EnrollmentModel> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public List<EnrollmentModel> findAll() {
        return enrollmentRepository.findAll();
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public EnrollmentModel update(EnrollmentModel enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
