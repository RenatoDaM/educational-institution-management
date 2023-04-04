package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.ProfessorModel;
import com.educational.educationalinstitutionmanagement.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorModel save(ProfessorModel professor) {
        return professorRepository.save(professor);
    }

    public Optional<ProfessorModel> findById(Long id) {
        return professorRepository.findById(id);
    }

    public List<ProfessorModel> findAll() {
        return professorRepository.findAll();
    }

    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

    public ProfessorModel update(ProfessorModel professor) {
        return professorRepository.save(professor);
    }
}
