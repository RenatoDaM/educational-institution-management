package com.educational.repository;

import com.educational.model.EducationalUnitModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalUnitRepository extends JpaRepository<EducationalUnitModel, Long> {
    Page<EducationalUnitModel> findAll(Pageable pageable);
}
