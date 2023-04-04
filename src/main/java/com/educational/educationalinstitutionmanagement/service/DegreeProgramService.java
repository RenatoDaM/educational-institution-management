package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.DegreeProgramModel;
import com.educational.educationalinstitutionmanagement.repository.DegreeProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DegreeProgramService {


    @Autowired
    private DegreeProgramRepository degreeProgramRepository;

    public DegreeProgramModel save(DegreeProgramModel degreeProgram) {
        return degreeProgramRepository.save(degreeProgram);
    }

    public Optional<DegreeProgramModel> findById(Long id) {
        return degreeProgramRepository.findById(id);
    }

    public List<DegreeProgramModel> findAll() {
        return degreeProgramRepository.findAll();
    }

    public void deleteById(Long id) {
        degreeProgramRepository.deleteById(id);
    }

    public DegreeProgramModel update(DegreeProgramModel degreeProgram) {
        return degreeProgramRepository.save(degreeProgram);
    }
}
