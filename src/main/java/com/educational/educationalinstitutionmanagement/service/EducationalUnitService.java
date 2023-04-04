package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EducationalUnitService {

    @Autowired
    private EducationalUnitRepository educationalUnitRepository;

    public EducationalUnitModel save(EducationalUnitModel educationalUnit) {
        return educationalUnitRepository.save(educationalUnit);
    }

    public Optional<EducationalUnitModel> findById(Long id) {
        return educationalUnitRepository.findById(id);
    }

    public List<EducationalUnitModel> findAll() {
        return educationalUnitRepository.findAll();
    }

    public void deleteById(Long id) {
        educationalUnitRepository.deleteById(id);
    }

    public EducationalUnitModel update(EducationalUnitModel educationalUnit) {
        return educationalUnitRepository.save(educationalUnit);
    }
}
