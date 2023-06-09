package com.educational.educationalinstitutionmanagement.service;

import com.educational.educationalinstitutionmanagement.dto.StudentDTO;
import com.educational.educationalinstitutionmanagement.model.*;
import com.educational.educationalinstitutionmanagement.repository.EducationalContainsStudentRepository;
import com.educational.educationalinstitutionmanagement.repository.EducationalUnitRepository;
import com.educational.educationalinstitutionmanagement.repository.StudentRepository;
import com.educational.educationalinstitutionmanagement.util.mapstruct.StudentMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<EducationalUnitModel> updateEnrollmentStatus(Long educationalUnitId, Long studentId, EnrollmentStatusEnum status) {
        StudentModel studentModel = studentRepository.findById(studentId).get();
        studentModel.getEducationalUnits().stream().filter(e -> e.getEducationalUnit().getId() == educationalUnitId)
                .findFirst().get().setState(status.getStatus());
        educationalContainsStudentRepository.saveAll(studentModel.getEducationalUnits());
        return educationalContainsStudentRepository.findEnrolledInstitutionsById(studentModel.getId());
    }

    public void deleteRelation(Long educationalUnitId, Long studentId) {
        EducationalContainsStudentId educationalContainsStudentId = new EducationalContainsStudentId();
        educationalContainsStudentId.setStudentId(studentId);
        educationalContainsStudentId.setEducationalUnitId(educationalUnitId);
        EducationalContainsStudentModel relation = new EducationalContainsStudentModel();
        relation.setId(educationalContainsStudentId);

        educationalContainsStudentRepository.delete(relation);
    }

    public List<StudentDTO> getAllStudentsResume(Long unitId) {
        List<StudentModel> students = educationalContainsStudentRepository.findStudentsByInstitutionId(unitId);
        List<StudentDTO> studentsDTO = new ArrayList<>();
        students.stream().forEach(e -> studentsDTO.add(StudentMapper.INSTANCE.studentToStudentDTO(e)));
        return studentsDTO;
    }

    // delete vai ser a entidade mesmo a deletar. Recebendo student e educational unit
}
