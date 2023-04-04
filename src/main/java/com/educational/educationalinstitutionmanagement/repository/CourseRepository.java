package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
}
