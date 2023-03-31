package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String description;
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    CurriculumModel curriculum;

    @ManyToMany(mappedBy = "courses")
    List<ProfessorModel> professorModels;

    @OneToOne(mappedBy = "course")
    CourseHistoryModel courseHistory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CurriculumModel getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(CurriculumModel curriculum) {
        this.curriculum = curriculum;
    }

    public CourseHistoryModel getCourseHistory() {
        return courseHistory;
    }

    public void setCourseHistory(CourseHistoryModel courseHistory) {
        this.courseHistory = courseHistory;
    }
}
