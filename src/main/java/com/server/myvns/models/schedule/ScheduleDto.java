package com.server.myvns.models.schedule;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.group.Group;
import com.server.myvns.models.subject.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScheduleDto extends NamedEntity {
    private List<Subject> subjects;

    private Group group;
}
