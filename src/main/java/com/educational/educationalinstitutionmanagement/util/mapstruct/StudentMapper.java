package com.educational.educationalinstitutionmanagement.util.mapstruct;

import com.educational.educationalinstitutionmanagement.dto.StudentDTO;
import com.educational.educationalinstitutionmanagement.model.StudentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "ra", target = "ra")
    @Mapping(source = "birthDate", target = "birthDate")
    StudentDTO studentToStudentDTO(StudentModel studentModel);
    StudentModel studentDTOtoStudent(StudentDTO studentDTO);
}
