package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EducationalContainsStudentId implements Serializable {
    private static final long serialVersionUID = 7230168987417148069L;
    @Column(name = "educational_unit_id")
    private Long educationalUnitId;

    @Column(name = "student_id")
    private Long studentId;

    public Long getEducationalUnitId() {
        return educationalUnitId;
    }

    public void setEducationalUnitId(Long educationalUnitId) {
        this.educationalUnitId = educationalUnitId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
