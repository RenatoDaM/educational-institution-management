package com.educational.controller;

import com.educational.model.StudentModel;
import com.educational.response.Response;
import com.educational.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    ResponseEntity<StudentModel> registerStudent(@RequestBody StudentModel studentModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }

    @GetMapping("/search")
    ResponseEntity<Optional<StudentModel>> getStudent(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @GetMapping("/search/all")
    public ResponseEntity<Page<StudentModel>> getAllEducationalUnit(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Page<StudentModel> allEducationalUnit = studentService.findAll(pageable);
        return ResponseEntity.ok(allEducationalUnit);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel studentModel) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(studentModel));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response(200, "Student with id: " + id + " deleted."));
    }
}
