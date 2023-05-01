package com.educational.repository;

import com.educational.model.DegreeProgramModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeProgramRepository extends JpaRepository<DegreeProgramModel, Long> {
}
