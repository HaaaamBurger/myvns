package com.server.myvns.models.lecturer;

import com.server.myvns.models.PersonEntity;
import com.server.myvns.models.department.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lecturers")
public class Lecturer extends PersonEntity {

    @Column(name = "lecturer_status")
    @NotNull(message = "lecturer_status field cannot be empty")
    @Enumerated(EnumType.STRING)
    private LecturerStatus lecturer_status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "leading_department_id")
    private Department leading_department;

}
