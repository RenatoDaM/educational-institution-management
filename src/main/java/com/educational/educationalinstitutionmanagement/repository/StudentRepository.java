package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
