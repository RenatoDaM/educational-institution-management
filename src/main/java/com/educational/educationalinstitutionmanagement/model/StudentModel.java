package com.educational.educationalinstitutionmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDate birthDay;
    @Column(unique = true)
    String cpf;
    @Column(unique = true)
    String ra;
    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    EnrollmentModel enrollment;
    @OneToMany(mappedBy = "student")
    List<CourseHistoryModel> courseHistoryModel;
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    CurriculumModel curriculumModel;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<EducationalContainModel> educationalContainStudent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public EnrollmentModel getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(EnrollmentModel enrollment) {
        this.enrollment = enrollment;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<CourseHistoryModel> getCourseHistoryModel() {
        return courseHistoryModel;
    }

    public void setCourseHistoryModel(List<CourseHistoryModel> courseHistoryModel) {
        this.courseHistoryModel = courseHistoryModel;
    }

    public CurriculumModel getCurriculumModel() {
        return curriculumModel;
    }

    public void setCurriculumModel(CurriculumModel curriculumModel) {
        this.curriculumModel = curriculumModel;
    }

    public List<EducationalContainModel> getEducationalContainStudent() {
        return educationalContainStudent;
    }

    public void setEducationalContainStudent(List<EducationalContainModel> educationalContainStudent) {
        this.educationalContainStudent = educationalContainStudent;
    }
}
