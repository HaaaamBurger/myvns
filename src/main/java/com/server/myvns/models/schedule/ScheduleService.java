package com.server.myvns.models.schedule;

import com.server.myvns.common.mappers.ScheduleMapper;
import com.server.myvns.common.repository.ScheduleRepository;
import com.server.myvns.common.service.SimpleCrudService;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleService implements SimpleCrudService<ScheduleDto> {

    private final ScheduleMapper scheduleMapper;

    private final ScheduleRepository scheduleRepository;

    private final RepositoryUtilService<Schedule, Long> repositoryUtilService;

    @Override
    public List<ScheduleDto> getAll(Integer page, Integer size) {
        Page<Schedule> schedules = scheduleRepository.findAll(PageRequest.of(page, size));
        return scheduleMapper.toScheduleDtoList(schedules.getContent());
    }

    @Override
    public ScheduleDto save(ScheduleDto entity) {
        Schedule schedule = scheduleMapper.toSchedule(entity);
        return scheduleMapper.toScheduleDto(scheduleRepository.save(schedule));
    }

    @Override
    public ScheduleDto removeById(Long id) {
        Schedule schedule = repositoryUtilService.findEntityOrThrowException(scheduleRepository, id);
        scheduleRepository.delete(schedule);
        return scheduleMapper.toScheduleDto(schedule);
    }

    @Override
    public ScheduleDto getById(Long id) {
        Schedule schedule = repositoryUtilService.findEntityOrThrowException(scheduleRepository, id);
        return scheduleMapper.toScheduleDto(schedule);
    }

    @Override
    public ScheduleDto updatedById(Long id, ScheduleDto entity) {
        Schedule schedule = repositoryUtilService.findEntityOrThrowException(scheduleRepository, id);

        schedule.setSubject(entity.getSubject());

        return scheduleMapper.toScheduleDto(scheduleRepository.save(schedule));
    }
}
