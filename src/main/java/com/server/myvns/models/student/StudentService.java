package com.server.myvns.models.student;

import com.server.myvns.common.mappers.StudentMapper;
import com.server.myvns.common.repository.StudentRepository;
import com.server.myvns.common.service.SimpleCrudService;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements SimpleCrudService<StudentDto> {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final RepositoryUtilService<Student, Long> repositoryUtilService;

    @Override
    public List<StudentDto> getAll(Integer page, Integer size) {
        Page<Student> students = studentRepository.findAll(PageRequest.of(page, size));
        return studentMapper.toStudentDtoList(students.getContent());
    }

    @Override
    public StudentDto save(StudentDto entity) {
        Student student = studentMapper.toStudent(entity);
        return studentMapper.toStudentDto(studentRepository.save(student));
    }

    @Override
    public StudentDto removeById(Long id) {
        Student student = repositoryUtilService.findEntityOrThrowException(studentRepository, id);
        studentRepository.delete(student);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto getById(Long id) {
        Student student = repositoryUtilService.findEntityOrThrowException(studentRepository, id);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto updatedById(Long id, StudentDto entity) {
        Student student = repositoryUtilService.findEntityOrThrowException(studentRepository, id);

        student.setFirstname(entity.getFirstname());
        student.setLastname(entity.getLastname());
        student.setStudent_status(entity.getStudent_status());

        return studentMapper.toStudentDto(studentRepository.save(student));
    }
}

