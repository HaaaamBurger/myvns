package com.server.myvns.models.department;

import com.server.myvns.common.mappers.DepartmentMapper;
import com.server.myvns.common.repositories.DepartmentRepository;
import com.server.myvns.common.repositories.LecturerRepository;
import com.server.myvns.common.services.SimpleCrudService;
import com.server.myvns.models.lecturer.Lecturer;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements SimpleCrudService<DepartmentDto> {

    private final DepartmentMapper departmentMapper;

    private final DepartmentRepository departmentRepository;

    private final LecturerRepository lecturerRepository;

    private final RepositoryUtilService<Department, Long> departmentUtilService;

    private final RepositoryUtilService<Lecturer, Long> lecturerUtilService;

    @Override
    public List<DepartmentDto> getAll(Integer page, Integer size) {
        Page<Department> departments = departmentRepository.findAll(PageRequest.of(page, size));
        return departmentMapper.toDepartmentDtoList(departments.getContent());
    }

    @Override
    public DepartmentDto save(DepartmentDto entity) {
        Department department = departmentMapper.toDepartment(entity);
        return departmentMapper.toDepartmentDro(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto removeById(Long id) {
        Department department = departmentUtilService.findEntityOrThrowException(departmentRepository, id);
        departmentRepository.delete(department);
        return departmentMapper.toDepartmentDro(department);
    }

    @Override
    public DepartmentDto getById(Long id) {
        Department department = departmentUtilService.findEntityOrThrowException(departmentRepository, id);
        return departmentMapper.toDepartmentDro(department);
    }

    @Override
    public DepartmentDto updatedById(Long id, DepartmentDto entity) {
        Department department = departmentUtilService.findEntityOrThrowException(departmentRepository, id);

        department.setName(entity.getName());

        departmentRepository.save(department);

        return departmentMapper.toDepartmentDro(department);
    }

    @Transactional
    public DepartmentDto assignLeadingLecturerToDepartment(Long lecturerId, Long departmentId) {
        Lecturer lecturer = lecturerUtilService.findEntityOrThrowException(lecturerRepository, lecturerId);
        Department department = departmentUtilService.findEntityOrThrowException(departmentRepository, departmentId);

        department.setLeading_lecturer(lecturer);
        lecturer.setDepartment(department);

        departmentRepository.save(department);
        lecturerRepository.save(lecturer);

        return departmentMapper.toDepartmentDro(department);
    }
}
