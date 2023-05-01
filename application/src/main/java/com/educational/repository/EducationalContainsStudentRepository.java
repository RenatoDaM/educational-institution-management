package com.educational.repository;

import com.educational.model.EducationalContainsStudentModel;
import com.educational.model.EducationalUnitModel;
import com.educational.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationalContainsStudentRepository extends JpaRepository<EducationalContainsStudentModel, Long> {
    //@Modifying não é necessário pois é só um select, não modifica o banco de dados.
    boolean existsByEducationalUnit(EducationalUnitModel educationalUnitModel);

    boolean existsByEducationalUnitAndStudent(EducationalUnitModel educationalUnitModel, StudentModel studentModel);

    // Nao usei @ManyToMany então tive que fazer de forma explícita. Lembrar que com JPA você tem que se referir às
    // CLASSES e não às TABELAS lá do banco.
    @Query("SELECT student FROM StudentModel student JOIN EducationalContainsStudentModel relation ON relation.student = student JOIN relation.educationalUnit educationalUnit WHERE  educationalUnit.id = :id")
    List<StudentModel> findStudentsByInstitutionId(@Param("id") Long id);

    @Query("SELECT educationalUnit FROM EducationalUnitModel educationalUnit JOIN EducationalContainsStudentModel relation ON relation.educationalUnit = educationalUnit JOIN relation.student student WHERE  student.id = :id")
    List<EducationalUnitModel> findEnrolledInstitutionsById(@Param("id") Long id);
}
