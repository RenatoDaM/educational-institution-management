/*package com.educational.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professor_teaches_course")
public class ProfessorTeachesCourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    ProfessorModel professor;
    @ManyToOne
    @JoinColumn(name = "course_id")
    CourseModel course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }
}*/
