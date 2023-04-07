package com.educational.educationalinstitutionmanagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "educational_unit")
public class EducationalUnitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String state;
    String city;
    @OneToMany(mappedBy = "educationalUnit")
    List<EducationalContainModel> educationalContainModelList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<EducationalContainModel> getEducationalContainModelList() {
        return educationalContainModelList;
    }

    public void setEducationalContainModelList(List<EducationalContainModel> educationalContainModelList) {
        this.educationalContainModelList = educationalContainModelList;
    }
}
