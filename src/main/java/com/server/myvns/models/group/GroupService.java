package com.server.myvns.models.group;

import com.server.myvns.common.mappers.GroupMapper;
import com.server.myvns.common.repository.GroupRepository;
import com.server.myvns.common.service.SimpleCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService implements SimpleCrudService<GroupDto> {

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    @Override
    public List<GroupDto> getAll(Integer page, Integer size) {
        Page<Group> groups = groupRepository.findAll(PageRequest.of(page, size));
        return groupMapper.toGroupDtoList(groups.getContent());
    }

    @Override
    public GroupDto save(GroupDto entity) {
        return null;
    }

    @Override
    public GroupDto removeById(Long id) {
        return null;
    }

    @Override
    public GroupDto getById(Long id) {
        return null;
    }

    @Override
    public GroupDto updatedById(Long id, GroupDto entity) {
        return null;
    }
}
