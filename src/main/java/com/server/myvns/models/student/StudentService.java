package com.server.myvns.models.student;

import com.server.myvns.common.mappers.StudentMapper;
import com.server.myvns.common.repositories.DepartmentRepository;
import com.server.myvns.common.repositories.StudentRepository;
import com.server.myvns.common.services.SimpleCrudService;
import com.server.myvns.models.department.Department;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService implements SimpleCrudService<StudentDto> {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final DepartmentRepository departmentRepository;

    private final RepositoryUtilService<Student, Long> repositoryStudentUtilService;

    private final RepositoryUtilService<Department, Long> repositoryDepartmentUtilService;

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
        Student student = repositoryStudentUtilService.findEntityOrThrowException(studentRepository, id);
        studentRepository.delete(student);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto getById(Long id) {
        Student student = repositoryStudentUtilService.findEntityOrThrowException(studentRepository, id);
        return studentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto updatedById(Long id, StudentDto entity) {
        Student student = repositoryStudentUtilService.findEntityOrThrowException(studentRepository, id);

        student.setFirstname(entity.getFirstname());
        student.setLastname(entity.getLastname());
        student.setStudent_status(entity.getStudent_status());

        return studentMapper.toStudentDto(studentRepository.save(student));
    }

    @Transactional
    public StudentDto assignStudentToDepartment(Long studentId, Long departmentId) {
        Student student = repositoryStudentUtilService.findEntityOrThrowException(studentRepository, studentId);
        Department department = repositoryDepartmentUtilService.findEntityOrThrowException(departmentRepository, departmentId);

        student.setDepartment(department);

        studentRepository.save(student);

        System.out.println(student.getDepartment().getName());

        return studentMapper.toStudentDto(student);
    }
}

