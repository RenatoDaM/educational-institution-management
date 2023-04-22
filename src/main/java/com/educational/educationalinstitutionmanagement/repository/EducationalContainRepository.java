package com.educational.educationalinstitutionmanagement.repository;

import com.educational.educationalinstitutionmanagement.model.EducationalContainsStudentModel;
import com.educational.educationalinstitutionmanagement.model.EducationalUnitModel;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalContainRepository extends JpaRepository<EducationalContainsStudentModel, Long> {
    //@Modifying não é necessário pois é só um select, não modifica o banco de dados.
    boolean existsByEducationalUnit(EducationalUnitModel educationalUnitModel);

    boolean existsByEducationalUnitAndStudent(EducationalUnitModel educationalUnitModel, StudentModel studentModel);
}
