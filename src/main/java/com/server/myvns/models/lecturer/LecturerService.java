package com.server.myvns.models.lecturer;

import com.server.myvns.common.mappers.LecturerMapper;
import com.server.myvns.common.repositories.LecturerRepository;
import com.server.myvns.common.services.SimpleCrudService;
import com.server.myvns.util.RepositoryUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService implements SimpleCrudService<LecturerDto> {

    private final LecturerMapper lecturerMapper;

    private final LecturerRepository lecturerRepository;

    private final RepositoryUtilService<Lecturer, Long> lecturerUtilService;

    @Override
    public List<LecturerDto> getAll(Integer page, Integer size) {
        Page<Lecturer> lecturers = lecturerRepository.findAll(PageRequest.of(page, size));
        return lecturerMapper.toLecturerDtoList(lecturers.getContent());
    }

    @Override
    public LecturerDto save(LecturerDto entity) {
        Lecturer lecturer = lecturerMapper.toLecturer(entity);
        return lecturerMapper.toLecturerDro(lecturerRepository.save(lecturer));
    }

    @Override
    public LecturerDto removeById(Long id) {
        Lecturer lecturer = lecturerUtilService.findEntityOrThrowException(lecturerRepository, id);
        lecturerRepository.delete(lecturer);
        return lecturerMapper.toLecturerDro(lecturer);
    }

    @Override
    public LecturerDto getById(Long id) {
        Lecturer lecturer = lecturerUtilService.findEntityOrThrowException(lecturerRepository, id);
        return lecturerMapper.toLecturerDro(lecturer);
    }

    @Override
    public LecturerDto updatedById(Long id, LecturerDto entity) {
        Lecturer lecturer = lecturerUtilService.findEntityOrThrowException(lecturerRepository, id);

        lecturer.setFirstname(entity.getFirstname());
        lecturer.setLastname(entity.getLastname());
        lecturer.setLeading_department(entity.getLeading_department());
        lecturer.setLecturer_status(entity.getLecturer_status());

        lecturerRepository.save(lecturer);

        return lecturerMapper.toLecturerDro(lecturer);
    }
}
