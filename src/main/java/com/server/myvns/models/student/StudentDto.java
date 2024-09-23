package com.server.myvns.models.student;

import com.server.myvns.models.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDto extends PersonEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "student_status")
    @NotNull(message = "student_status field cannot be empty")
    private StudentStatus student_status;
}
