package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "degree_program")
public class DegreeProgramModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToOne(mappedBy = "degreeProgramModel")
    CurriculumModel curriculum;

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

    public CurriculumModel getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(CurriculumModel curriculum) {
        this.curriculum = curriculum;
    }
}
