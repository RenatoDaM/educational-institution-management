package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curriculum")
public class CurriculumModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "degree_program_id")
    DegreeProgramModel degreeProgramModel;

    @OneToMany(mappedBy = "curriculum")
    List<CourseModel> courseModelList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DegreeProgramModel getDegreeProgramModel() {
        return degreeProgramModel;
    }

    public void setDegreeProgramModel(DegreeProgramModel degreeProgramModel) {
        this.degreeProgramModel = degreeProgramModel;
    }

    public List<CourseModel> getCourseModelList() {
        return courseModelList;
    }

    public void setCourseModelList(List<CourseModel> courseModelList) {
        this.courseModelList = courseModelList;
    }

}
