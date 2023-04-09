package com.educational.educationalinstitutionmanagement.controller;

import com.educational.educationalinstitutionmanagement.model.ProfessorModel;
import com.educational.educationalinstitutionmanagement.response.Response;
import com.educational.educationalinstitutionmanagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping("/register/professor")
    ResponseEntity<ProfessorModel> registerProfessor(@RequestBody ProfessorModel professorModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorModel));
    }

    @GetMapping("/search/professor")
    ResponseEntity<Optional<ProfessorModel>> getProfessor(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findById(id));
    }

    @PutMapping("/update/professor")
    ResponseEntity<ProfessorModel> updateProfessor(@RequestBody ProfessorModel professorModel) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professorModel));
    }

    @DeleteMapping("/delete/professor/{id}")
    ResponseEntity<Response> deleteProfessor(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Response(201, "Professor deleted"));
    }
}
