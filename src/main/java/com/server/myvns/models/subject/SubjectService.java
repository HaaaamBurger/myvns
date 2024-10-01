package com.server.myvns.models.subject;

import com.server.myvns.common.mappers.SubjectMapper;
import com.server.myvns.common.repositories.SubjectRepository;
import com.server.myvns.common.services.SimpleCrudService;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService implements SimpleCrudService<SubjectDto> {
    private final SubjectMapper subjectMapper;

    private final SubjectRepository subjectRepository;

    private final RepositoryUtilService<Subject, Long> repositoryUtilService;

    @Override
    public List<SubjectDto> getAll(Integer page, Integer size) {
        Page<Subject> subjects = subjectRepository.findAll(PageRequest.of(page, size));
        return subjectMapper.toSubjectDtoList(subjects.getContent());
    }

    @Override
    public SubjectDto save(SubjectDto entity) {
        Subject subject = subjectMapper.toSubject(entity);
        return subjectMapper.toSubjectDto(subjectRepository.save(subject));
    }

    @Override
    public SubjectDto removeById(Long id) {
        Subject subject = repositoryUtilService.findEntityOrThrowException(subjectRepository, id);
        subjectRepository.delete(subject);
        return subjectMapper.toSubjectDto(subject);
    }

    @Override
    public SubjectDto getById(Long id) {
        Subject subject = repositoryUtilService.findEntityOrThrowException(subjectRepository, id);
        return subjectMapper.toSubjectDto(subject);
    }

    @Override
    public SubjectDto updatedById(Long id, SubjectDto entity) {
        Subject subject = repositoryUtilService.findEntityOrThrowException(subjectRepository, id);

        subject.setName(entity.getName());

        return subjectMapper.toSubjectDto(subjectRepository.save(subject));
    }
}
