package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.model.EducationalContainsStudentId;
import com.educational.educationalinstitutionmanagement.model.EducationalContainsStudentModel;
import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalContainsStudentRepository;
import com.educational.educationalinstitutionmanagement.repository.EducationalUnitRepository;
import com.educational.educationalinstitutionmanagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationalContainService {

    @Autowired
    EducationalContainsStudentRepository educationalContainsStudentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EducationalUnitRepository educationalUnitRepository;

    @Transactional
    public StudentModel registerStudentInUnit(EducationalUnitModel educationalUnitModel, StudentModel studentModel) {
        var educationalContainsStudentModel = new EducationalContainsStudentModel();
        educationalContainsStudentModel.setStudent(studentModel);
        educationalContainsStudentModel.setEducationalUnit(educationalUnitModel);
        var educationalContainsStudentId = new EducationalContainsStudentId();
        educationalContainsStudentId.setEducationalUnitId(educationalUnitModel.getId());
        educationalContainsStudentId.setStudentId(studentModel.getId());
        educationalContainsStudentModel.setId(educationalContainsStudentId);
        educationalContainsStudentRepository.save(educationalContainsStudentModel);
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

    public List<StudentModel> findStudentsByInstitutionId(Long educationalUnitId) {
        return educationalContainsStudentRepository.findStudentsByInstitutionId(educationalUnitId);
    }

    public List<EducationalUnitModel> findEnrolledInstitutionsById(Long id) {
        return educationalContainsStudentRepository.findEnrolledInstitutionsById(id);
    }

    // delete vai ser a entidade mesmo a deletar. Recebendo student e educational unit
}
