package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalContainModel;
import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalContainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EducationalContainService {

    @Autowired
    private EducationalContainRepository educationalContainRepository;

    public StudentModel registerStudentInUnit(EducationalUnitModel educationalUnitModel, StudentModel studentModel) {
        EducationalContainModel educationalContainModel = new EducationalContainModel();
        educationalContainModel.setEducationalUnit(educationalUnitModel);
        educationalContainModel.setStudent(studentModel);
        if (!educationalContainRepository.existsByEducationalUnitAndStudent(educationalUnitModel, studentModel)) {
            educationalContainRepository.save(educationalContainModel);
            studentModel.getEducationalContainStudent().add(educationalContainModel);
        } else {
            studentModel.getEducationalContainStudent().add(educationalContainModel);
        }
        return studentModel;

        // CÓDIGO EXEMPLO:

        /*
    EducationalUnitModel educationalUnit = educationalUnitRepository.findById(student.getEducationalUnit().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Educational Unit not found"));

    EducationalContainModel educationalContain = educationalContainRepository.findByEducationalUnitAndStudent(educationalUnit, student)
            .orElse(new EducationalContainModel(educationalUnit, student));

    student.getEducationalContains().add(educationalContain);
    educationalUnit.getEducationalContains().add(educationalContain);

    return studentRepository.save(student);*/
    }

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
