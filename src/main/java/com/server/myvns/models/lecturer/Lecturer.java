package com.server.myvns.models.lecturer;

import com.server.myvns.models.PersonEntity;
import com.server.myvns.models.department.Department;
import com.server.myvns.models.subject.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lecturers")
public class Lecturer extends PersonEntity {

    @Column(name = "lecturer_status")
    @NotNull(message = "lecturer_status field cannot be empty")
    @Enumerated(EnumType.STRING)
    private LecturerStatus lecturer_status;

    @OneToOne
    @JoinColumn(name = "leading_department_id")
    private Department department;

}
