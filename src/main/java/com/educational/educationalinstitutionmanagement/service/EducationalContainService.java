package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalContainModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalContainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EducationalContainService {

    @Autowired
    private EducationalContainRepository educationalContainRepository;

    public EducationalContainModel save(EducationalContainModel educationalContain) {
        return educationalContainRepository.save(educationalContain);
    }

    public Optional<EducationalContainModel> findById(Long id) {
        return educationalContainRepository.findById(id);
    }

    public List<EducationalContainModel> findAll() {
        return educationalContainRepository.findAll();
    }

    public void deleteById(Long id) {
        educationalContainRepository.deleteById(id);
    }

    public EducationalContainModel update(EducationalContainModel educationalContain) {
        return educationalContainRepository.save(educationalContain);
    }
}
