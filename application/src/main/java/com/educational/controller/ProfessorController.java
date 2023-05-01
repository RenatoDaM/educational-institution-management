package com.educational.controller;

import com.educational.model.ProfessorModel;
import com.educational.response.Response;
import com.educational.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping("/register")
    ResponseEntity<ProfessorModel> registerProfessor(@RequestBody ProfessorModel professorModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorModel));
    }

    @GetMapping("/search")
    ResponseEntity<Optional<ProfessorModel>> getProfessor(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findById(id));
    }

    @GetMapping("/search/all")
    public ResponseEntity<Page<ProfessorModel>> getAllEducationalUnit(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Page<ProfessorModel> allEducationalUnit = professorService.findAll(pageable);
        return ResponseEntity.ok(allEducationalUnit);
    }

    @PutMapping("/update")
    ResponseEntity<ProfessorModel> updateProfessor(@RequestBody ProfessorModel professorModel) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professorModel));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Response> deleteProfessor(@PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Response(201, "Professor deleted"));
    }
}
