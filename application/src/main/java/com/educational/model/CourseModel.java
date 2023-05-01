package com.educational.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    CurriculumModel curriculum;

    @ManyToMany(mappedBy = "courses")
    List<ProfessorModel> professorModels;

    @OneToOne(mappedBy = "course")
    CourseHistoryModel courseHistory;

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

    public List<ProfessorModel> getProfessorModels() {
        return professorModels;
    }

    public void setProfessorModels(List<ProfessorModel> professorModels) {
        this.professorModels = professorModels;
    }
}
