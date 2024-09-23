package com.server.myvns.models.student;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<StudentDto> toStudentDtoList(List<Student> studentList);

    List<Student> toStudentList(List<StudentDto> studentDtoList);

    StudentDto toStudentDto(Student student);

    Student toStudent(StudentDto studentDto);
}
