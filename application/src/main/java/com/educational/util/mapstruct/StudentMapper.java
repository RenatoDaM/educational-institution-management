package com.educational.util.mapstruct;

import com.educational.dto.StudentDTO;
import com.educational.model.StudentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO studentToStudentDTO(StudentModel studentModel);
    StudentModel studentDTOtoStudent(StudentDTO studentDTO);
}
