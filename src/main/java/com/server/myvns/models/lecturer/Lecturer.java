package com.server.myvns.models.lecturer;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToOne(mappedBy = "leading_lecturer",fetch = FetchType.LAZY)
    private Department department;

}
