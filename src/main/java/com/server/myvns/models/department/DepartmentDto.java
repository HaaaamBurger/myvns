package com.server.myvns.models.department;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.lecturer.Lecturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto extends NamedEntity {
    private Lecturer leading_lecturer;
}
