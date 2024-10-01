package com.server.myvns.common.mappers;

import com.server.myvns.models.lecturer.Lecturer;
import com.server.myvns.models.lecturer.LecturerDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface LecturerMapper {
    List<LecturerDto> toLecturerDtoList(List<Lecturer> lecturerList);

    List<Lecturer> toLecturerList(List<LecturerDto> lecturerDtoList);

    LecturerDto toLecturerDro(Lecturer lecturer);

    Lecturer toLecturer(LecturerDto lecturerDto);
}
