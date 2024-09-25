package com.server.myvns.models.group;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.schedule.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends NamedEntity {
    private Schedule schedule;
}
