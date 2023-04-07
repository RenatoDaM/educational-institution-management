package com.educational.educationalinstitutionmanagement.controller;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.response.Response;
import com.educational.educationalinstitutionmanagement.service.EducationalUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/educational-unit")
public class EducationalUnitController {
    @Autowired
    EducationalUnitService educationalUnitService;

    @PostMapping("/create/educational-unit")
    ResponseEntity<EducationalUnitModel> createEducationalUnit(@RequestBody EducationalUnitModel educationalUnitModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educationalUnitService.save(educationalUnitModel));
    }

    @GetMapping("/search/educational-unit")
    ResponseEntity<Optional<EducationalUnitModel>> readEducationalUnit(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalUnitService.findById(id));
    }

    @PutMapping("/update/educational-unit")
    ResponseEntity<EducationalUnitModel> updateEducationalUnit(@RequestBody EducationalUnitModel educationalUnitModel) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalUnitService.update(educationalUnitModel));
    }

    @DeleteMapping("/delete/educational-unit/{id}")
    ResponseEntity<Response> deleteEducationalUnit(@PathVariable Long id) {
        educationalUnitService.deleteById(id);
        Response response = new Response(201, "Educational unit successfully deleted");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
