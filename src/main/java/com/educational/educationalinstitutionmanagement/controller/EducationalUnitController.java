package com.educational.educationalinstitutionmanagement.controller;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.repository.EducationalContainRepository;
import com.educational.educationalinstitutionmanagement.response.Response;
import com.educational.educationalinstitutionmanagement.service.EducationalUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/educational-unit")
public class EducationalUnitController {
    @Autowired
    EducationalUnitService educationalUnitService;
    @Autowired
    private EducationalContainRepository educationalContainRepository;

    @PostMapping("/register")
    ResponseEntity<EducationalUnitModel> registerEducationalUnit(@RequestBody EducationalUnitModel educationalUnitModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educationalUnitService.save(educationalUnitModel));
    }

    @GetMapping("/search")
    ResponseEntity<Optional<EducationalUnitModel>> readEducationalUnit(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalUnitService.findById(id));
    }

    @GetMapping("/search/all")
    public ResponseEntity<Page<EducationalUnitModel>> getAllEducationalUnit(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Page<EducationalUnitModel> allEducationalUnit = educationalUnitService.findAll(pageable);
        return ResponseEntity.ok(allEducationalUnit);
    }


    @PutMapping("/update")
    ResponseEntity<EducationalUnitModel> updateEducationalUnit(@RequestBody EducationalUnitModel educationalUnitModel) {
        return ResponseEntity.status(HttpStatus.OK).body(educationalUnitService.update(educationalUnitModel));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Response> deleteEducationalUnit(@PathVariable Long id) {
        educationalUnitService.deleteById(id);
        Response response = new Response(201, "Educational unit successfully deleted");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
