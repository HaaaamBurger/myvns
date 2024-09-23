package com.server.myvns.models.student;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student fromDto(StudentDto studentDto);
}

