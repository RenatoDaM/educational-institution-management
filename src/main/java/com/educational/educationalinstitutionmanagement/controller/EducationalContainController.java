package com.educational.educationalinstitutionmanagement.controller;

import com.educational.educationalinstitutionmanagement.model.EducationalContainModel;
import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.ProfessorModel;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import com.educational.educationalinstitutionmanagement.service.EducationalContainService;
import com.educational.educationalinstitutionmanagement.service.EducationalUnitService;
import com.educational.educationalinstitutionmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/register-at-educational-unit")
public class EducationalContainController {

    @Autowired
    EducationalContainService educationalContainService;

    @Autowired
    StudentService studentService;
    @Autowired
    EducationalUnitService educationalUnitService;

    @PostMapping("/{educationalUnitId}/student/{studentId}")
    ResponseEntity<StudentModel> registerStudent(@PathVariable Long educationalUnitId, @PathVariable Long studentId) {
        System.out.println("Hello");
        EducationalUnitModel educationalUnitModel = educationalUnitService.findById(educationalUnitId).get();
        System.out.println("Hello 2");
        StudentModel studentModel = studentService.findById(studentId).get();
        System.out.println("Hello 3");
        StudentModel studentResponse = educationalContainService.registerStudentInUnit(educationalUnitModel, studentModel);
        System.out.println("uashduash");
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }
}
