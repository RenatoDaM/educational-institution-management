package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.CourseHistoryModel;
import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseHistoryRepository extends JpaRepository<CourseHistoryModel, Long> {
}
