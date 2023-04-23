package com.educational.educationalinstitutionmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "educational_unit")
public class EducationalUnitModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String state;
    String city;

    @OneToMany(mappedBy = "educationalUnit")
    @JsonIgnore
    Set<EducationalContainsStudentModel> students;

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

    public Set<EducationalContainsStudentModel> getStudents() {
        return students;
    }

    public void setStudents(Set<EducationalContainsStudentModel> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
