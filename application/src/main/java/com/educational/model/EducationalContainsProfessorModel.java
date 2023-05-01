package com.educational.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "educational_contains_professor")
public class EducationalContainsProfessorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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

    public List<EducationalUnitModel> getEducationalUnitModels() {
        return educationalUnitModels;
    }

    public void setEducationalUnitModels(List<EducationalUnitModel> educationalUnitModels) {
        this.educationalUnitModels = educationalUnitModels;
    }
}
