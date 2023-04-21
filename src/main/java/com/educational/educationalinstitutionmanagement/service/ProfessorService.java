package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.ProfessorModel;
import com.educational.educationalinstitutionmanagement.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorModel save(ProfessorModel professor) {
        return professorRepository.save(professor);
    }

    public Optional<ProfessorModel> findById(Long id) {
        return professorRepository.findById(id);
    }

    public Page<ProfessorModel> findAll(Pageable pageable) {
        return professorRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

    public ProfessorModel update(ProfessorModel professor) {
        return professorRepository.save(professor);
    }
}
