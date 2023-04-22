package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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
}
