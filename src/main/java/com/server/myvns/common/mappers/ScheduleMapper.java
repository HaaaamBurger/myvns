package com.server.myvns.common.mappers;

import com.server.myvns.models.schedule.Schedule;
import com.server.myvns.models.schedule.ScheduleDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    List<ScheduleDto> toScheduleDtoList(List<Schedule> scheduleList);

    List<Schedule> toScheduleList(List<ScheduleDto> scheduleDtoList);

    ScheduleDto toScheduleDto(Schedule schedule);

    Schedule toSchedule(ScheduleDto scheduleDto);
}
