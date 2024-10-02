package com.server.myvns.models.lecturer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.myvns.models.PersonEntity;
import com.server.myvns.models.department.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerDto extends PersonEntity {

    private LecturerStatus lecturer_status;

    @JsonIgnore
    private Department department;
}
