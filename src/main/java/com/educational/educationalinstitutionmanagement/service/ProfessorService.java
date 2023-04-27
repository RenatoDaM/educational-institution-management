package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.dto.StudentDTO;
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

    @Autowired
    private EducationalUnitService educationalUnitService;

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

    public ProfessorModel registerProfessor(Long unitId, Long professorId) {
        ProfessorModel professorModel = professorRepository.findById(professorId).get();
        EducationalUnitModel educationalUnitModel = educationalUnitService.findById(unitId).get();
        professorModel.getEducationalUnitModels().add(educationalUnitModel);
        professorRepository.save(professorModel);
        return professorModel;
    }

    public List<EducationalUnitModel> getAllEnrolledUnits(Long professorId) {
        ProfessorModel professorModel = professorRepository.findById(professorId).get();
        List<EducationalUnitModel> educationalUnitModels = professorModel.getEducationalUnitModels();
        return educationalUnitModels;
    }


}
