package com.educational.repository;

import com.educational.model.CourseHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseHistoryRepository extends JpaRepository<CourseHistoryModel, Long> {
}
