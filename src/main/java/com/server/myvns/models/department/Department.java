package com.server.myvns.models.department;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.lecturer.Lecturer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department extends NamedEntity {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "leading_lecturer_id")
    private Lecturer leading_lecturer;
}
