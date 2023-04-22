package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalContainsStudentModel;
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
        EducationalContainsStudentModel educationalContainsStudentModel = new EducationalContainsStudentModel();
        educationalContainsStudentModel.setEducationalUnit(educationalUnitModel);
        educationalContainsStudentModel.setStudent(studentModel);
        if (!educationalContainRepository.existsByEducationalUnitAndStudent(educationalUnitModel, studentModel)) {
            educationalContainRepository.save(educationalContainsStudentModel);
            studentModel.getEducationalContainStudent().add(educationalContainsStudentModel);
        } else {
            studentModel.getEducationalContainStudent().add(educationalContainsStudentModel);
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

    public EducationalContainsStudentModel save(EducationalContainsStudentModel educationalContain) {
        return educationalContainRepository.save(educationalContain);
    }

    public Optional<EducationalContainsStudentModel> findById(Long id) {
        return educationalContainRepository.findById(id);
    }

    public List<EducationalContainsStudentModel> findAll() {
        return educationalContainRepository.findAll();
    }

    public void deleteById(Long id) {
        educationalContainRepository.deleteById(id);
    }

    public EducationalContainsStudentModel update(EducationalContainsStudentModel educationalContain) {
        return educationalContainRepository.save(educationalContain);
    }
}
