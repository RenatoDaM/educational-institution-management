package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
}
