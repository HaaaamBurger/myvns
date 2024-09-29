package com.server.myvns.common.mappers;


import com.server.myvns.models.department.Department;
import com.server.myvns.models.department.DepartmentDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    List<DepartmentDto> toDepartmentDtoList(List<Department> departmentList);

    List<Department> toDepartmentList(List<DepartmentDto> departmentDtoList);

    DepartmentDto toDepartmentDro(Department department);

    Department toDepartment(DepartmentDto departmentDto);
}
