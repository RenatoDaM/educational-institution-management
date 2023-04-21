package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationalUnitRepository extends JpaRepository<EducationalUnitModel, Long> {
    Page<EducationalUnitModel> findAll(Pageable pageable);
}
