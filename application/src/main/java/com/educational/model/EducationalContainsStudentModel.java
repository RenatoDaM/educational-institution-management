package com.educational.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "educational_contains_student")
public class EducationalContainsStudentModel {
    @EmbeddedId
    @JsonIgnore
    EducationalContainsStudentId id;

    @ManyToOne
    @MapsId("educationalUnitId")
    @JoinColumn(name = "educational_unit_id")
    private EducationalUnitModel educationalUnit;

    @JsonIgnore
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentModel student;
    String state;

    public EducationalContainsStudentId getId() {
        return id;
    }

    public void setId(EducationalContainsStudentId id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}