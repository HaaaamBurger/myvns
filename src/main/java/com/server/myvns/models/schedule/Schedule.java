package com.server.myvns.models.schedule;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.group.Group;
import com.server.myvns.models.subject.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "schedules")
public class Schedule extends NamedEntity {
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private List<Subject> subjects;

    @OneToOne(mappedBy = "schedule")
    private Group group;

}
