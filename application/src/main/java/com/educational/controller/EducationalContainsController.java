package com.educational.controller;

import com.educational.dto.StudentDTO;
import com.educational.model.EducationalUnitModel;
import com.educational.model.EnrollmentStatusEnum;
import com.educational.model.ProfessorModel;
import com.educational.model.StudentModel;
import com.educational.response.Response;
import com.educational.service.EducationalContainService;
import com.educational.service.EducationalUnitService;
import com.educational.service.ProfessorService;
import com.educational.service.StudentService;
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
    ProfessorService professorService;

    // STUDENT

    @PostMapping("/{unitId}/student/{studentId}")
    ResponseEntity<StudentModel> registerStudent(@PathVariable Long unitId, @PathVariable Long studentId) {
        EducationalUnitModel educationalUnitModel = educationalUnitService.findById(unitId).get();
        StudentModel studentModel = studentService.findById(studentId).get();
        StudentModel studentResponse = educationalContainService.registerStudentInUnit(educationalUnitModel, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    @RequestMapping("/students/{unitId}")
    ResponseEntity<List<StudentModel>> findStudentsByInstitution(@PathVariable Long unitId) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalContainService.findStudentsByInstitutionId(unitId));
    }

    // Vai retornar uma lista de estudantes apenas com informações básicas (nome, ra, etc)
    @RequestMapping("/students/resume/{unitId}")
    ResponseEntity<List<StudentDTO>> findStudentsByInstitutionResume(@PathVariable Long unitId) {
        return ResponseEntity.ok().body(educationalContainService.getAllStudentsResume(unitId));
    }


    @RequestMapping("/institutions/{studentId}")
    ResponseEntity<List<EducationalUnitModel>> findEnrolledInstitutionsById(@PathVariable Long studentId) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalContainService.findEnrolledInstitutionsById(studentId));
    }

    @PutMapping("enrollment/update/{unitId}/{studentId}")
    ResponseEntity<List<EducationalUnitModel>> updateEnrollmentState(@PathVariable Long unitId, @PathVariable Long studentId, @RequestParam EnrollmentStatusEnum status) {
        return ResponseEntity.ok(educationalContainService.updateEnrollmentStatus(unitId, studentId, status));
    }

    @DeleteMapping("/delete/student-from-institution/{unitId}/{studentId}")
    ResponseEntity<Response> deleteRelation(@PathVariable Long unitId, @PathVariable Long studentId) {
        educationalContainService.deleteRelation(unitId, studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Response(204, "Deleted successfully"));
    }

    // PROFESSOR

    @PostMapping("/{unitId}/professor/{professorId}")
    ResponseEntity<ProfessorModel> registerProfessor(@PathVariable Long unitId, @PathVariable Long professorId) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.registerProfessor(unitId, professorId));
    }

    @GetMapping("/{professorId}/professor")
    ResponseEntity<List<EducationalUnitModel>> getAllEnrolledUnits(@PathVariable Long professorId) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.getAllEnrolledUnits(professorId));
    }

    @DeleteMapping("/delete/professor-from-institution/{unitId}/{professorId}")
    ResponseEntity<Response> deleteProfessorRelation(@PathVariable Long unitId, @PathVariable Long professorId) {
        professorService.deleteFromUnit(unitId, professorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Response(204, "Deleted successfully"));
    }
}
