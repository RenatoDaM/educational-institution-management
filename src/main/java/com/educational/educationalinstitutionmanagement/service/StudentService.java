package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.StudentModel;
import com.educational.educationalinstitutionmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;



    public StudentModel save(StudentModel student) {
        return studentRepository.save(student);
    }

    public Optional<StudentModel> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Page<StudentModel> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentModel update(StudentModel student) {
        return studentRepository.save(student);
    }
}
