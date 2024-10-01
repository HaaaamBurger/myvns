package com.server.myvns.models.lecturer;

import com.fasterxml.jackson.annotation.JsonView;
import com.server.myvns.common.views.View;
import com.server.myvns.models.PersonEntity;
import com.server.myvns.models.department.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerDto extends PersonEntity {

    private LecturerStatus lecturer_status;

    @JsonView(View.Private.class)
    private Department leading_department;
}
