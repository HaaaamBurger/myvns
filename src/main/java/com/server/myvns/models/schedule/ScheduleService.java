package com.server.myvns.models.schedule;

import com.server.myvns.common.mappers.ScheduleMapper;
import com.server.myvns.common.repository.ScheduleRepository;
import com.server.myvns.common.repository.SubjectRepository;
import com.server.myvns.common.service.SimpleCrudService;
import com.server.myvns.models.subject.Subject;
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

    private final SubjectRepository subjectRepository;

    private final RepositoryUtilService<Schedule, Long> scheduleLongRepositoryUtilService;

    private final RepositoryUtilService<Subject, Long> subjectLongRepositoryUtilService;

    @Override
    public List<ScheduleDto> getAll(Integer page, Integer size) {
        Page<Schedule> schedules = scheduleRepository.findAll(PageRequest.of(page, size));
        return scheduleMapper.toScheduleDtoList(schedules.getContent());
    }

    @Override
    public ScheduleDto save(ScheduleDto entity) {
        Schedule schedule = scheduleMapper.toSchedule(entity);
        schedule.setSubjects(List.of());
        return scheduleMapper.toScheduleDto(scheduleRepository.save(schedule));
    }

    @Override
    public ScheduleDto removeById(Long id) {
        Schedule schedule = scheduleLongRepositoryUtilService.findEntityOrThrowException(scheduleRepository, id);
        scheduleRepository.delete(schedule);
        return scheduleMapper.toScheduleDto(schedule);
    }

    @Override
    public ScheduleDto getById(Long id) {
        Schedule schedule = scheduleLongRepositoryUtilService.findEntityOrThrowException(scheduleRepository, id);
        return scheduleMapper.toScheduleDto(schedule);
    }

    @Override
    public ScheduleDto updatedById(Long id, ScheduleDto entity) {
        Schedule schedule = scheduleLongRepositoryUtilService.findEntityOrThrowException(scheduleRepository, id);

        schedule.setSubjects(entity.getSubjects());

        return scheduleMapper.toScheduleDto(scheduleRepository.save(schedule));
    }

    public ScheduleDto addSubjectToSchedule(Long scheduleId, Long subjectId) {
        Schedule schedule = scheduleLongRepositoryUtilService.findEntityOrThrowException(scheduleRepository, scheduleId);
        Subject subject = subjectLongRepositoryUtilService.findEntityOrThrowException(subjectRepository, subjectId);

        schedule.getSubjects().add(subject);
        scheduleRepository.save(schedule);

        return scheduleMapper.toScheduleDto(schedule);
    }
}
