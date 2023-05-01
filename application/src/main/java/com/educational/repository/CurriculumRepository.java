package com.educational.repository;

import com.educational.model.CurriculumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<CurriculumModel, Long> {
}
