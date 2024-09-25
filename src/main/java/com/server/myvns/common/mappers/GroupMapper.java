package com.server.myvns.common.mappers;

import com.server.myvns.models.group.Group;
import com.server.myvns.models.group.GroupDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface GroupMapper {
    List<GroupDto> toGroupDtoList(List<Group> groupList);

    List<Group> toGroupList(List<GroupDto> groupDtoList);

    GroupDto toGroupDro(Group group);

    Group toGroup(GroupDto groupDto);
}
