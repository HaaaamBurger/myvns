package com.server.myvns.models.student;

import com.server.myvns.models.PersonEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends PersonEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "student_status")
    @NotNull(message = "student_status field cannot be empty")
    private StudentStatus student_status;

//    @Column(name = "group")
//    @ManyToOne
//    private Group group;

//    @Column(name = "department")
//    @NotNull(message = "department field cannot be empty")
//    @ManyToOne
//    private Department department;

//    @Column(name = "leading_lecturer")
//    @ManyToOne
//    private Lecturer leading_lecturer;

}
