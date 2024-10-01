package com.server.myvns.models.department;

import com.fasterxml.jackson.annotation.JsonView;
import com.server.myvns.common.views.View;
import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.lecturer.Lecturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto extends NamedEntity {
    @JsonView(View.Public.class)
    private Lecturer leading_lecturer;
}
