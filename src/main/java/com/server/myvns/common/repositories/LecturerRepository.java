package com.server.myvns.common.repositories;

import com.server.myvns.models.lecturer.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
}
