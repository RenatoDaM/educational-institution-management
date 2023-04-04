package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.DegreeProgramModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DegreeProgramRepository extends JpaRepository<DegreeProgramModel, Long> {
}
