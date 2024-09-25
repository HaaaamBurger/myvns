package com.server.myvns.common.mappers;

import com.server.myvns.models.subject.Subject;
import com.server.myvns.models.subject.SubjectDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SubjectMapper {
    List<SubjectDto> toSubjectDtoList(List<Subject> subjectList);

    List<Subject> toSubjectList(List<SubjectDto> subjectDtoList);

    SubjectDto toSubjectDto(Subject subject);

    Subject toSubject(SubjectDto subjectDto);
}
