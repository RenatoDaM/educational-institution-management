package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalContainModel;
import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalContainRepository;
import com.educational.educationalinstitutionmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    EducationalContainRepository educationalContainRepository;



    public StudentModel save(StudentModel student) {
        return studentRepository.save(student);
    }

    public Optional<StudentModel> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public StudentModel update(StudentModel student) {
        return studentRepository.save(student);
    }
}
