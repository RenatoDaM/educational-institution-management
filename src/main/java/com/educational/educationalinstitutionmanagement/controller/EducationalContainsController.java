package com.educational.educationalinstitutionmanagement.controller;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import com.educational.educationalinstitutionmanagement.repository.StudentRepository;
import com.educational.educationalinstitutionmanagement.service.EducationalContainService;
import com.educational.educationalinstitutionmanagement.service.EducationalUnitService;
import com.educational.educationalinstitutionmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/register-at-educational-unit")
public class EducationalContainsController {

    @Autowired
    EducationalContainService educationalContainService;

    @Autowired
    StudentService studentService;
    @Autowired
    EducationalUnitService educationalUnitService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/{educationalUnitId}/student/{studentId}")
    ResponseEntity<StudentModel> registerStudent(@PathVariable Long educationalUnitId, @PathVariable Long studentId) {
        EducationalUnitModel educationalUnitModel = educationalUnitService.findById(educationalUnitId).get();
        StudentModel studentModel = studentService.findById(studentId).get();
        StudentModel studentResponse = educationalContainService.registerStudentInUnit(educationalUnitModel, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    @RequestMapping("/students/{educationalUnitId}")
    ResponseEntity<List<StudentModel>> findStudentsByInstitution(@PathVariable Long educationalUnitId) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalContainService.findStudentsByInstitutionId(educationalUnitId));
    }

    @RequestMapping("/institutions/{studentId}")
    ResponseEntity<List<StudentModel>> findEnrolledInstitutionsById(@PathVariable Long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalContainService.findStudentsByInstitutionId(studentId));
    }
}
