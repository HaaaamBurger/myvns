package com.server.myvns.common.mappers;

import com.server.myvns.models.student.Student;
import com.server.myvns.models.student.StudentDto;
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
