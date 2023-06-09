package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(unique = true)
    String cpf;

    @OrderColumn(name = "order_index")
    @ManyToMany
    @JoinTable(name = "professor_teaches",
    joinColumns = @JoinColumn(name = "professor_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id"))
    List<CourseModel> courses;
    // vai mapear por "courses"

    @ManyToMany
    @JoinTable(name = "educational_contains_professor",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "educational_unit_id"))
    List<EducationalUnitModel> educationalUnitModels;

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

    public List<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseModel> courses) {
        this.courses = courses;
    }

    public List<EducationalUnitModel> getEducationalUnitModels() {
        return educationalUnitModels;
    }

    public void setEducationalUnitModels(List<EducationalUnitModel> educationalUnitModels) {
        this.educationalUnitModels = educationalUnitModels;
    }
}
