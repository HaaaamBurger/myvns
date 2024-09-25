package com.server.myvns.models.group;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.schedule.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDto extends NamedEntity {
    private Schedule schedule;
}
