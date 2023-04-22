package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "educational_contains_student")
public class EducationalContainsStudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "educational_unit_id")
    EducationalUnitModel educationalUnit;
    @ManyToOne
    @JoinColumn(name = "student_id")
    StudentModel student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public EducationalUnitModel getEducationalUnit() {
        return educationalUnit;
    }

    public void setEducationalUnit(EducationalUnitModel educationalUnit) {
        this.educationalUnit = educationalUnit;
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

}
