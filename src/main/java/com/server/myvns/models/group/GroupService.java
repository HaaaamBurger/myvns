package com.server.myvns.models.group;

import com.server.myvns.common.mappers.GroupMapper;
import com.server.myvns.common.repositories.GroupRepository;
import com.server.myvns.common.repositories.ScheduleRepository;
import com.server.myvns.common.services.SimpleCrudService;
import com.server.myvns.models.schedule.Schedule;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService implements SimpleCrudService<GroupDto> {

    private final GroupRepository groupRepository;

    private final ScheduleRepository scheduleRepository;

    private final GroupMapper groupMapper;

    private final RepositoryUtilService<Group, Long> groupRepositoryUtilService;
    private final RepositoryUtilService<Schedule, Long> scheduleRepositoryUtilService;

    @Override
    public List<GroupDto> getAll(Integer page, Integer size) {
        Page<Group> groups = groupRepository.findAll(PageRequest.of(page, size));
        return groupMapper.toGroupDtoList(groups.getContent());
    }

    @Override
    public GroupDto save(GroupDto entity) {
        Group group = groupMapper.toGroup(entity);
        return groupMapper.toGroupDro(groupRepository.save(group));
    }

    @Override
    public GroupDto removeById(Long id) {
        Group group = groupRepositoryUtilService.findEntityOrThrowException(groupRepository, id);
        groupRepository.delete(group);
        return groupMapper.toGroupDro(group);
    }

    @Override
    public GroupDto getById(Long id) {
        Group group = groupRepositoryUtilService.findEntityOrThrowException(groupRepository, id);
        return groupMapper.toGroupDro(group);
    }

    @Override
    public GroupDto updatedById(Long id, GroupDto entity) {
        Group group = groupRepositoryUtilService.findEntityOrThrowException(groupRepository, id);

        group.setName(entity.getName());
        group.setSchedule(entity.getSchedule());

        groupRepository.save(group);

        return groupMapper.toGroupDro(group);
    }

    public GroupDto assignScheduleToGroup(Long groupId, Long scheduleId) {
        Group group = groupRepositoryUtilService.findEntityOrThrowException(groupRepository, groupId);
        Schedule schedule = scheduleRepositoryUtilService.findEntityOrThrowException(scheduleRepository, scheduleId);

        group.setSchedule(schedule);

        groupRepository.save(group);

        return groupMapper.toGroupDro(group);
    }
}
