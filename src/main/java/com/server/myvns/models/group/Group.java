package com.server.myvns.models.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.schedule.Schedule;
import com.server.myvns.models.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends NamedEntity {
    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
