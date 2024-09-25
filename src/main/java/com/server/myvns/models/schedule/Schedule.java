package com.server.myvns.models.schedule;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.subject.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "schedules")
public class Schedule extends NamedEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("name")
    private List<Subject> subject;
}
