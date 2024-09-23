package com.server.myvns.models.student;

import com.server.myvns.common.repository.StudentRepository;
import com.server.myvns.common.service.SimpleCrudService;
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

    @Override
    public List<StudentDto> getAll(Integer page, Integer size) {
        Page<Student> students = studentRepository.findAll(PageRequest.of(page, size));
        return students.map(studentMapper::toDto).getContent();
    }

    @Override
    public StudentDto save(StudentDto entity) {
        Student student = studentMapper.fromDto(entity);

        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public StudentDto removeById(Long id) {
        return null;
    }

    @Override
    public StudentDto getById(Long id) {
        return null;
    }

    @Override
    public StudentDto updatedById(Long id, StudentDto entity) {
        return null;
    }
}

