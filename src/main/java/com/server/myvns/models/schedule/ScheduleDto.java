package com.server.myvns.models.schedule;

import com.server.myvns.models.subject.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScheduleDto {
    private List<Subject> subject;
}
